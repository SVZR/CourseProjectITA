package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewCoinFullDescriptionDto {

    private long id;
    private String name;
    private String description;
    private String metal;
    private long denomination;
    private long mintage;
    private long weight;
    private long diameter;
    private String image;
}
