package dto;

import entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateNewUserDto {

    private String login;
    private String password;
    private String email;
    private UserRole role;
}
