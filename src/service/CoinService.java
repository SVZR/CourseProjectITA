package service;

import dao.CoinDao;
import dao.CoinDescriptionDao;
import dto.ViewAllCoinsByCountryDto;
import dto.ViewCoinByIdDto;
import dto.ViewCoinDescriptionDto;
import entity.Coin;
import entity.Metal;

import java.util.List;
import java.util.stream.Collectors;

public final class CoinService {

    private static CoinService INSTANCE = null;

    private CoinService() {}

    public static CoinService getInstance() {
        if (INSTANCE == null) {
            synchronized (CoinService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CoinService();
                }
            }
        }
        return INSTANCE;
    }

    public List<ViewAllCoinsByCountryDto> getCoinsByCountry(long countryId) {
        return CoinDao.getInstance().findAllCoinByCountry(countryId).stream()
                .map(coinEntity -> new ViewAllCoinsByCountryDto(coinEntity.getId(), coinEntity.getName(),
                        coinEntity.getSeries().getId(), coinEntity.getImage()))
                .collect(Collectors.toList());
    }

    public ViewCoinByIdDto getCoinFullInfo(long coinId) {
        Coin coin = CoinDao.getInstance().findCoinById(coinId);
        System.out.println(coin.getSeries().getTheme().getCountry().getName());
        return new ViewCoinByIdDto(coin.getSeries().getTheme().getCountry().getName(),
                coin.getSeries().getTheme().getName(),
                coin.getSeries().getName(),
                coin.getName(),
                coin.getReleaseDate(),
                coin.getDesigner(),
                coin.getMintedBy(),
                CoinDescriptionService.getInstance().getAllCoinDescriptionsByCoinId(coinId),
                coin.getDescriptionObverse(),
                coin.getDescriptionRevers());
    }
}
