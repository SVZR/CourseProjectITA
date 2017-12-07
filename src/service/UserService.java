package service;

import dao.UserDao;
import dto.*;
import entity.User;
import entity.UserRole;

import java.util.Arrays;
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

    public ViewUserLoginInfoDto getUserLoginInfoByEmail(String email) {
        User user = UserDao.getInstance().findByEmail(email).orElse(null);
        if (user != null) {
            System.out.println("ViewUserLoginInfoDto created");
            return new ViewUserLoginInfoDto(user.getId(), user.getEmail(), user.getPassword(), user.getUserRole().toString());
        } else {
            System.out.println("ViewUserLoginInfoDto not created");
            return null;
        }
    }

    public ViewUserFullInfoDto getUserFullInfoByUserName(String username) {
        User user = UserDao.getInstance().findByUserName(username).orElse(null);
        if (user != null) {
            return new ViewUserFullInfoDto(user.getId(), user.getLogin(), user.getEmail(), user.getUserRole().toString());
        } else {
            return null;
        }
    }

    public ViewUserFullInfoDto getUserFullInfoByUserId(long userId) {
        User user = UserDao.getInstance().findByUserId(userId).orElse(null);
        if (user != null) {
            return new ViewUserFullInfoDto(user.getId(), user.getLogin(), user.getEmail(), user.getUserRole().toString());
        } else {
            return null;
        }
    }

    public long createNewUser(CreateNewUserDto dto) {
        return UserDao.getInstance().create(new User(dto.getLogin(), dto.getPassword(), dto.getEmail(), dto.getRole())).getId();
    }

    public UserSessionDto getUserSessionInfo(String inputEmail, String inputPassword) {
        ViewUserLoginInfoDto userLoginInfoDto = getUserLoginInfoByEmail(inputEmail);
        if (userLoginInfoDto != null) {
            if (userLoginInfoDto.getPassword().equals(inputPassword)) {
                System.out.println("UserSessionDto created");

                return new UserSessionDto(userLoginInfoDto.getId(), userLoginInfoDto.getUserRole());
            }
        }
        System.out.println("UserSessionDto not created");
        return null;
    }

    public void changeUserRole(long userID, String newUserRole) {
        UserDao.getInstance().changeUserRole(userID, newUserRole);
    }

    public List<String> getAllUserRoles() {
        return Arrays.stream(UserRole.values()).map(Enum::toString).collect(Collectors.toList());
    }
}
