package service;

import dao.CollectionDao;
import dto.ViewCountryWithCoinsAmountDto;

import java.util.List;

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
        CollectionDao.getInstance().updateCoinInCollection(userId, coinDescriptionId, amount);
        System.out.println("updatecoinservicemethod");
    }
}
