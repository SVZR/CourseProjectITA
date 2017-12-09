package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ViewCoinInCollectionByCountryDto {

    private long seriesId;
    private long coinId;
    private String coinName;
    private long amount;
}
