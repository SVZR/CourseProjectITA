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
public class ViewUserBasicInfoDto {

    private long id;
    private String login;
    private String email;
    private String userRole;
}
