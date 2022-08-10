package com.nlu.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nlu.app.entity.User;
import com.nlu.app.service.UserService;

import org.apache.commons.validator.routines.EmailValidator;



@Component
public class UserValidator implements Validator {
	
	private EmailValidator emailValidator = EmailValidator.getInstance();

	@Autowired
	private UserService userService;

	// Các lớp được hỗ trợ bởi Validator này.
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == User.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User appUserForm = (User) target;

		// Kiểm tra các field của AppUserForm.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.appUserForm.username");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.appUserForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.appUserForm.password");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.appUserForm.confirmPassword");
		
		if (!this.emailValidator.isValid(appUserForm.getEmail())) {
			// Email không hợp lệ.
			errors.rejectValue("email", "Pattern.appUserForm.email");
		} else if (appUserForm.getId() == null) {
			User dbUser = userService.findByEmail(appUserForm.getEmail());
			if (dbUser != null) {
				// Email đã được sử dụng bởi tài khoản khác.
				errors.rejectValue("email", "Duplicate.appUserForm.email");
			}
		}

		if (!errors.hasFieldErrors("username")) {
			User dbUser = userService.findByUserName(appUserForm.getUsername());
			if (dbUser != null) {
				// Tên tài khoản đã bị sử dụng bởi người khác.
				errors.rejectValue("username", "Duplicate.appUserForm.username");
			}
		}

//		if (!errors.hasErrors()) {
//			if (!appUserForm.getConfirmPassword().equals(appUserForm.getPassword())) {
//				errors.rejectValue("confirmPassword", "Match.appUserForm.confirmPassword");
//			}
//		}
	}


}

