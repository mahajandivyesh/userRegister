package com.dvsapp.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dvsapp.registration.entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Integer>{

}
