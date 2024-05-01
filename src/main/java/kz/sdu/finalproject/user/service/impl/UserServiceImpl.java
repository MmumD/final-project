package kz.sdu.finalproject.user.service.impl;

import kz.sdu.finalproject.core.exceptions.BadRequestException;
import kz.sdu.finalproject.core.exceptions.UserNotFoundException;
import kz.sdu.finalproject.user.dto.UserCreateRequest;
import kz.sdu.finalproject.user.dto.UserUpdateRequest;
import kz.sdu.finalproject.user.dto.UserView;
import kz.sdu.finalproject.user.entity.UserEntity;
import kz.sdu.finalproject.user.mapper.UserMapper;
import kz.sdu.finalproject.user.repository.UserRepository;
import kz.sdu.finalproject.user.service.UserService;
import kz.sdu.finalproject.user.util.GetUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    private GetUsername getUsername;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Transactional(readOnly = true)
    @Override
    public UserView loadUserById(Long id) {
        return repository.findById(id).map(UserMapper.INSTANCE::toView)
                .orElseThrow(() -> new UserNotFoundException("User not exits"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserView> loadAll() {
        return repository.findAll().stream().map(UserMapper.INSTANCE::toView).toList();
    }

    @Transactional
    @Override
    public boolean registerUser(UserCreateRequest request) {
        if(repository.existsByUsername(request.getUsername()))
            throw new BadRequestException("User already exists");

        if(request.getPassword().length() < 8 || request.getPassword().length() > 25)
            throw new BadRequestException("Password length must be between 8 and 25");

        if(!request.getPassword().equals(request.getRePassword()))
            throw new BadRequestException("Passwords not same");

        UserEntity entity = UserMapper.INSTANCE.toEntity(request);
        entity.setPassword(encoder.encode(request.getPassword()));

        repository.save(entity);

        return true;
    }

    @Transactional
    @Override
    public boolean updatePassword(String token,UserUpdateRequest request) {
        UserEntity entity = repository.findUserEntityByUsername(getUsername.getUsername(token))
                .orElseThrow(() -> new UserNotFoundException("User not exits"));

        if(!encoder.matches(request.getOldPassword(),entity.getPassword()))
            throw new BadRequestException("Old password is incorrect");

        if(request.getPassword().length() < 8 || request.getPassword().length() > 25)
            throw new BadRequestException("Password length must be between 8 and 25");

        if(!request.getPassword().equals(request.getRePassword()))
            throw new BadRequestException("Passwords not same");

        entity = UserMapper.INSTANCE.toUpdateEntity(entity, request);

        entity.setPassword(encoder.encode(request.getPassword()));

        repository.save(entity);

        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) {
        return repository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not exits"));
    }


}
