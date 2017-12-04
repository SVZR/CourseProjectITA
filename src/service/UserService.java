package service;

import dao.UserDao;
import dto.CreateNewUserDto;
import dto.ViewUserBasicInfoDto;
import dto.ViewUserLoginInfoDto;
import entity.User;

import java.util.List;
import java.util.stream.Collectors;

public final class UserService {

    private static UserService INSTANCE = null;

    private UserService() {}

    public static UserService getInstance() {
        if (INSTANCE == null) {
            synchronized (UserService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserService();
                }
            }
        }
        return INSTANCE;
    }

    public List<ViewUserBasicInfoDto> getAllUsers() {
        return UserDao.getInstance().findAll().stream()
                .map(userEntity -> new ViewUserBasicInfoDto(userEntity.getId(), userEntity.getLogin(), userEntity.getEmail()))
                .collect(Collectors.toList());
    }

    public ViewUserLoginInfoDto getUserLoginInfo(String email) {
        User user = UserDao.getInstance().findByEmail(email).orElse(null);
        if (user != null) {
            return new ViewUserLoginInfoDto(user.getId(), user.getEmail(), user.getPassword());
        } else {
            return null;
        }
    }

    public long createNewUser(CreateNewUserDto dto) {
        return UserDao.getInstance().create(new User(dto.getLogin(), dto.getPassword(), dto.getEmail(), dto.getRole())).getId();
    }

    public long isUserExist(String inputEmail, String inputPassword) {
        ViewUserLoginInfoDto userLoginInfoDto = getUserLoginInfo(inputEmail);
        if (userLoginInfoDto != null) {
            if (userLoginInfoDto.getPassword().equals(inputPassword)) {
                return userLoginInfoDto.getId();
            }
        }
        return -1;
    }
}
