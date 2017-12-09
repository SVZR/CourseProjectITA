package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewCoinDescriptionDto {

    private long id;
    private String metal;
    private long denomination;
    private double weight;
    private double diameter;
    private long mintage;
    private String imageObverse;
    private String imageReverse;
}
