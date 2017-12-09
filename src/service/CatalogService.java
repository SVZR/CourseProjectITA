package service;

import dto.ViewCatalogCoinsByCountryDto;

public final class CatalogService {

    private static CatalogService INSTANCE = null;

    private CatalogService() {}

    public static CatalogService getInstance() {
        if (INSTANCE == null) {
            synchronized (CatalogService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CatalogService();
                }
            }
        }
        return INSTANCE;
    }

    public ViewCatalogCoinsByCountryDto getCatalogCoinsByCountry(long countryId) {
        ViewCatalogCoinsByCountryDto catalog = new ViewCatalogCoinsByCountryDto();
        catalog.setThemes(ThemeService.getInstance().getThemesByCountry(countryId));
        catalog.setSeries(SeriesService.getInstance().getSeriesByCountry(countryId));
        catalog.setCoins(CoinService.getInstance().getCoinsByCountry(countryId));
        return catalog;
    }


}
