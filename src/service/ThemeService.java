package service;

import dao.ThemeDao;
import dto.ViewAllThemesByCountryDto;
import dto.ViewAllThemesDto;
import entity.Country;
import entity.Theme;

import java.util.List;
import java.util.stream.Collectors;

public final class ThemeService {

    private static ThemeService INSTANCE = null;

    private ThemeService() {}

    public static ThemeService getInstance() {
        if (INSTANCE == null) {
            synchronized (ThemeService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThemeService();
                }
            }
        }
        return INSTANCE;
    }

    public List<ViewAllThemesByCountryDto> getThemesByCountry(long countryId) {
        return ThemeDao.getInstance().findAllByCountry(countryId).stream()
                .map(themeEntity -> new ViewAllThemesByCountryDto(themeEntity.getId(), themeEntity.getName()))
                .collect(Collectors.toList());
    }

    public List<ViewAllThemesDto> getAllThemes() {
        return ThemeDao.getInstance().findAll().stream()
                .map(themeEntity -> new ViewAllThemesDto(themeEntity.getId(), themeEntity.getName(), themeEntity.getCountry().getId()))
                .collect(Collectors.toList());
    }

    public long createNewTheme(long countryId, String themeName) {
        Theme theme = new Theme();
        theme.setName(themeName);
        Country country = new Country();
        country.setId(countryId);
        theme.setCountry(country);
        return ThemeDao.getInstance().create(theme).getId();
    }
}
