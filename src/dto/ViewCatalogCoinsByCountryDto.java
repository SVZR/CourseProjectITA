package dto;

import java.util.List;

public class ViewCatalogCoinsByCountryDto {
    private List<ViewAllThemesByCountryDto> themes;
    private List<ViewAllSeriesByCountryDto> series;
    private List<ViewAllCoinsByCountryDto> coins;

    public ViewCatalogCoinsByCountryDto(List<ViewAllThemesByCountryDto> themes, List<ViewAllSeriesByCountryDto> series, List<ViewAllCoinsByCountryDto> coins) {
        this.themes = themes;
        this.series = series;
        this.coins = coins;
    }

    public ViewCatalogCoinsByCountryDto() {}

    public List<ViewAllThemesByCountryDto> getThemes() {
        return themes;
    }

    public void setThemes(List<ViewAllThemesByCountryDto> themes) {
        this.themes = themes;
    }

    public List<ViewAllSeriesByCountryDto> getSeries() {
        return series;
    }

    public void setSeries(List<ViewAllSeriesByCountryDto> series) {
        this.series = series;
    }

    public List<ViewAllCoinsByCountryDto> getCoins() {
        return coins;
    }

    public void setCoins(List<ViewAllCoinsByCountryDto> coins) {
        this.coins = coins;
    }
}
