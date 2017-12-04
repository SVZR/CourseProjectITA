package entity;



public class Series {

    private long id;
    private String name;
    private Theme theme;

    public Series() {}

    public Series(long id, String name, Theme theme) {
        this.id = id;
        this.name = name;
        this.theme = theme;
    }

    public Series(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Series(String name, Theme theme) {
        this.name = name;
        this.theme = theme;
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

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
