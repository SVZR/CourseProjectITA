package dto;

public class ViewAllSeriesByCountryDto {
    private long id;
    private String name;
    private long themeId;

    public ViewAllSeriesByCountryDto(long id, String name, long themeId) {
        this.id = id;
        this.name = name;
        this.themeId = themeId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getThemeId() {
        return themeId;
    }

    public void setThemeId(long themeId) {
        this.themeId = themeId;
    }
}
