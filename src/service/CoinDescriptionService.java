package service;

import dao.CoinDescriptionDao;
import dao.CollectionDao;
import dto.CoinDescriptionAddingDto;
import dto.TestDto;
import dto.ViewCoinAmountInCollectionDto;
import dto.ViewCoinDescriptionDto;
import entity.Coin;
import entity.CoinDescription;
import entity.Metal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public HashMap<Long, Long> getAmountCoinInCollectionByCoinId(long coinId, long userId) {
        HashMap<Long, Long> test = new HashMap<>();
        CollectionDao.getInstance().findCoinDescriptionAmountInCollectionByCoinId(coinId, userId)
                .forEach(coll -> test.put(coll.getCoinDescription().getId(), coll.getAmount()));
        return test;
    }

    public void addCoinDescription(CoinDescriptionAddingDto coin) {
        Coin coinId = new Coin();
        coinId.setId(coin.getCoinId());
        Metal metalId = new Metal();
        metalId.setId(coin.getMetalId());

        CoinDescriptionDao.getInstance().create(new CoinDescription(
        coinId,
        metalId,
        coin.getDenomination(),
        coin.getMintage(),
        coin.getWeight(),
        coin.getDiameter(),
        coin.getImageObverse(),
        coin.getImageReverse()));
    }
}
