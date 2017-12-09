package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoinDescriptionAddingDto {
    private long coinId;
    private long metalId;
    private long denomination;
    private long mintage;
    private double weight;
    private double diameter;
    private String imageObverse;
    private String imageReverse;
}
