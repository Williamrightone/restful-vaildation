package com.william.restvaild.repos.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.william.restvaild.repos.po.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String>{

	public Optional<UserEntity> findByEmail(String email);
	
}
