package dto;

public class UserSessionDto {
    private long userId;
    private String userRole;

    public UserSessionDto(long userId, String userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
