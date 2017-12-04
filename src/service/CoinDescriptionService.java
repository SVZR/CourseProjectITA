package service;

import dao.CoinDescriptionDao;
import dto.ViewCoinDescriptionDto;

import java.util.List;
import java.util.stream.Collectors;

public final class CoinDescriptionService {

    private static CoinDescriptionService INSTANCE = null;

    private CoinDescriptionService() {}

    public static CoinDescriptionService getInstance() {
        if (INSTANCE == null) {
            synchronized (CoinDescriptionService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CoinDescriptionService();
                }
            }
        }
        return INSTANCE;
    }

    public List<ViewCoinDescriptionDto> getAllCoinDescriptionsByCoinId(long coinId) {
        return CoinDescriptionDao.getInstance().findCoinDescriptionByCoinId(coinId).stream()
                .map(coinDescription -> new ViewCoinDescriptionDto(coinDescription.getId(),
                        coinDescription.getMetal().getName(),
                        coinDescription.getDenomination(),
                        coinDescription.getWeight(),
                        coinDescription.getDiameter(),
                        coinDescription.getMintage(),
                        coinDescription.getImageObverse(),
                        coinDescription.getImageReverse()))
                .collect(Collectors.toList());
    }
}
