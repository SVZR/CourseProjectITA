package service;

import dao.CollectionDao;
import dto.ViewCoinInCollectionByCountryDto;
import dto.ViewSeriesInCollectionByCountryDto;
import dto.ViewThemesInCollectionByCountryDto;

import java.util.List;
import java.util.stream.Collectors;

public final class MyCollectionService {
    private static MyCollectionService INSTANCE = null;

    private MyCollectionService() {}

    public static MyCollectionService getInstance() {
        if (INSTANCE == null) {
            synchronized (MyCollectionService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MyCollectionService();
                }
            }
        }
        return INSTANCE;
    }

    public void addCoinToCellection(long userId, long coinDescriptionId, long amount) {
        CollectionDao.getInstance().addCoinToCollection(userId, coinDescriptionId, amount);
    }

    public void updateCoinInCollection(long userId, long coinDescriptionId, long amount) {
        CollectionDao.getInstance().updateCoinAmountInCollection(userId, coinDescriptionId, amount);
    }

    public List<ViewCoinInCollectionByCountryDto> getCoinsInCollectionByUserId(long userId, long countryId) {
        return CollectionDao.getInstance().findCoinsInCollectionByCountry(userId, countryId)
                .stream()
                .map(coin -> new ViewCoinInCollectionByCountryDto(
                        coin.getSeries().getId(),
                        coin.getId(),
                        coin.getName(),
                        coin.getAmount()))
                .collect(Collectors.toList());
    }

    public List<ViewThemesInCollectionByCountryDto> getThemesInCollectionByUserId(long userId, long countryId) {
        return CollectionDao.getInstance().findThemesInCollectionByCountry(userId, countryId).stream()
                .map(theme -> new ViewThemesInCollectionByCountryDto(theme.getId(),
                        theme.getName(),
                        theme.getAmount()))
                .collect(Collectors.toList());
    }

    public List<ViewSeriesInCollectionByCountryDto> getSeriesInCollectionByUserId(long userId, long countryId) {
        return CollectionDao.getInstance().findSeriesInCollectionByCountry(userId, countryId).stream()
                .map(series -> new ViewSeriesInCollectionByCountryDto(series.getId(),
                        series.getName(),
                        series.getTheme().getId(),
                        series.getAmount()))
                .collect(Collectors.toList());
    }
}
