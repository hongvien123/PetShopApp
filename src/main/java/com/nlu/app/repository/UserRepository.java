package com.nlu.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.app.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
