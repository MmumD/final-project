package kz.sdu.finalproject.user.service.impl;

import kz.sdu.finalproject.core.exceptions.UserNotFoundException;
import kz.sdu.finalproject.user.entity.UserEntity;
import kz.sdu.finalproject.user.repository.UserRepository;
import kz.sdu.finalproject.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Transactional(readOnly = true)
    @Override
    public UserEntity loadUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not exits"));
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not exits"));
    }
}
