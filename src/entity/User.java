package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String login;
    private String password;
    private String email;
    private UserRole userRole;

    public User(String login, String password, String email, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }
}
