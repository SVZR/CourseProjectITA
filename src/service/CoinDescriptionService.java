package service;

import dao.CoinDescriptionDao;
import dao.CollectionDao;
import dto.TestDto;
import dto.ViewCoinAmountInCollectionDto;
import dto.ViewCoinDescriptionDto;

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

//    public List<ViewCoinAmountInCollectionDto> getAmountCoinInCollectionByCoinId(long coinId, long userId) {
//        return CollectionDao.getInstance().findCoinDescriptionAmountInCollectionByCoinId(coinId, userId)
//                .stream()
//                .map(coll -> new ViewCoinAmountInCollectionDto(coll.getCoinDescription().getId(), coll.getAmount()))
//                .peek(coll -> System.out.println(coll.getCoinDescriptionId() + " amount " + coll.getAmount()))
//                .collect(Collectors.toList());
//    }

    public HashMap<Long, Long> getAmountCoinInCollectionByCoinId(long coinId, long userId) {
        HashMap<Long, Long> test = new HashMap<>();
        CollectionDao.getInstance().findCoinDescriptionAmountInCollectionByCoinId(coinId, userId)
                .forEach(coll -> test.put(coll.getCoinDescription().getId(), coll.getAmount()));
        return test;
    }
}
