package com.application.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.entity.User;
import com.application.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	
	
	private UserRepository userRepository;	
	public UserServiceImpl(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}	
	

	@Override
	public List<User> findAll() {		
		return userRepository.findAll();
	}

	@Override
	public User findById(int id) {
		Optional<User> result = userRepository.findById(id);		
		User user = null;
		
		if(result.isPresent()) {
			user = result.get();
		}else {
			throw new RuntimeException("user id not found - "+id);
		}	
		
		return user;		
	}
	

	@Override
	public User save(User user) {
		User saveUser = userRepository.save(user);		
		return saveUser;
		
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);		
	}


	

	

}
