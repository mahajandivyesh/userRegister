package com.dvsapp.registration.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvsapp.registration.dto.UserDTO;
import com.dvsapp.registration.entity.UserEntity;
import com.dvsapp.registration.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository iUserRepository;

	@Override
	public UserDTO saveUser(UserDTO user) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		iUserRepository.save(entity);
		if(entity.getId()!=null){
			BeanUtils.copyProperties(entity, user);
		}
		return user;
	}
}
