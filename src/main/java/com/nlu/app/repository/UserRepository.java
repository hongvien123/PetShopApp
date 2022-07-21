package com.nlu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.app.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
<<<<<<< HEAD

=======
	
	public List<UserEntity> findByUsername(String username);
	
>>>>>>> 33ed6d8fb222e653867a156effe58ebd14210548
}
