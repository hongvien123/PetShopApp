package com.nlu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlu.app.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
