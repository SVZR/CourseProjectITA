package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewSeriesInCollectionByCountryDto {

    private long seriesId;
    private String seriesName;
    private long themeId;
    private long amount;
}
