package kz.sdu.finalproject.user.dto;

import kz.sdu.finalproject.user.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserView {

    private Long id;
    private String username;
    private UserRoles role = UserRoles.ROLE_USER;
}
