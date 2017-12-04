package service;

import dao.MetalDao;
import dao.UserDao;
import dto.ViewAllMetalsDto;
import dto.ViewUserBasicInfoDto;

import java.util.List;
import java.util.stream.Collectors;

public final class MetalService {
    private static MetalService INSTANCE = null;

    private MetalService() {}

    public static MetalService getInstance() {
        if (INSTANCE == null) {
            synchronized (MetalService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MetalService();
                }
            }
        }
        return INSTANCE;
    }

    public List<ViewAllMetalsDto> getAllMetals() {
        return MetalDao.getInstance().findAll().stream()
                .map(metalEntity -> new ViewAllMetalsDto(metalEntity.getId(), metalEntity.getName()))
                .collect(Collectors.toList());
    }
}
