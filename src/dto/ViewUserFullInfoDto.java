package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewUserFullInfoDto {

    private long id;
    private String userName;
    private String userEmail;
    private String userRole;
}
