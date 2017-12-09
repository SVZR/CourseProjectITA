package service;

import dao.SeriesDao;
import dto.ViewAllSeriesByCountryDto;
import dto.ViewAllSeriesDto;
import entity.Series;
import entity.Theme;

import java.util.List;
import java.util.stream.Collectors;

public final class SeriesService {

    private static SeriesService INSTANCE = null;

    private SeriesService() {}

    public static SeriesService getInstance() {
        if (INSTANCE == null) {
            synchronized (SeriesService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SeriesService();
                }
            }
        }
        return INSTANCE;
    }

    public List<ViewAllSeriesByCountryDto> getSeriesByCountry(long countryId) {
        return SeriesDao.getInstance().findAllByCountry(countryId).stream()
                .map(seriesEntity -> new ViewAllSeriesByCountryDto(seriesEntity.getId(), seriesEntity.getName(), seriesEntity.getTheme().getId()))
                .collect(Collectors.toList());
    }

    public List<ViewAllSeriesDto> getAllSeries() {
        return SeriesDao.getInstance().findAll().stream()
                .map(seriesEntity -> new ViewAllSeriesDto(seriesEntity.getId(), seriesEntity.getName(), seriesEntity.getTheme().getId()))
                .collect(Collectors.toList());
    }

    public void addSeries(String seriesName, long themeId) {
        Series series = new Series();
        series.setName(seriesName);
        Theme theme = new Theme();
        theme.setId(themeId);
        series.setTheme(theme);
        SeriesDao.getInstance().create(series);
    }
}
