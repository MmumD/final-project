package kz.sdu.finalproject.user.service;

import kz.sdu.finalproject.user.dto.UserCreateRequest;
import kz.sdu.finalproject.user.dto.UserUpdateRequest;
import kz.sdu.finalproject.user.dto.UserView;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserView loadUserById(Long id);

    List<UserView> loadAll();

    boolean registerUser(UserCreateRequest request);

    boolean updatePassword(String token,UserUpdateRequest request);

}
