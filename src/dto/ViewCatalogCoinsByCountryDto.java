package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewCatalogCoinsByCountryDto {

    private List<ViewAllThemesByCountryDto> themes;
    private List<ViewAllSeriesByCountryDto> series;
    private List<ViewAllCoinsByCountryDto> coins;
}
