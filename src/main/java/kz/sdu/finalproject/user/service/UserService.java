package kz.sdu.finalproject.user.service;

import kz.sdu.finalproject.user.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserEntity loadUserById(Long id);

}
