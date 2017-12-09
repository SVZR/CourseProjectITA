package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewUserLoginInfoDto {

    private long id;
    private String email;
    private String password;
    private String userRole;
}
