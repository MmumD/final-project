package kz.sdu.finalproject.user.service;

import kz.sdu.finalproject.user.dto.UserCreateRequest;
import kz.sdu.finalproject.user.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserEntity loadUserById(Long id);

    List<UserEntity> loadAll();

    boolean registerUser(UserCreateRequest request);


}
