package service;

import dao.CoinDao;
import dao.CoinDescriptionDao;
import dto.*;
import entity.Coin;
import entity.Metal;
import entity.Series;

import java.time.format.DateTimeFormatter;
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
                        coinEntity.getSeries().getId()))
                .collect(Collectors.toList());
    }

    public ViewCoinByIdDto getCoinFullInfo(long coinId) {
        Coin coin = CoinDao.getInstance().findCoinById(coinId);
        return new ViewCoinByIdDto(coin.getSeries().getTheme().getCountry().getName(),
                coin.getSeries().getTheme().getName(),
                coin.getSeries().getName(),
                coin.getName(),
                coin.getReleaseDate().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")),
                coin.getDesigner(),
                coin.getMintedBy(),
                CoinDescriptionService.getInstance().getAllCoinDescriptionsByCoinId(coinId),
                coin.getDescriptionObverse(),
                coin.getDescriptionRevers());
    }

    public List<ViewCoinBaseInfoDto> getAllCoinsId() {
        return CoinDao.getInstance().findAllCoins().stream()
                .map(coin -> new ViewCoinBaseInfoDto(coin.getId(), coin.getName()))
        .collect(Collectors.toList());
    }

    public void addCoin(ViewCoinForAddingDto dto) {
        Series series = new Series();
        series.setId(dto.getId());
        Coin coin = new Coin(dto.getCoinName(),
                series,
                dto.getReleaseDate(),
                dto.getDesigner(),
                dto.getMintedBy(),
                dto.getDescriptionObverse(),
                dto.getDescriptionReverse());

        coin.setSeries(series);


        CoinDao.getInstance().create(coin);

    }
}
