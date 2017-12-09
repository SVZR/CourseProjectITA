package entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Series {

    private long id;
    private String name;
    private Theme theme;
    private long amount;

    public Series(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Series(String name, Theme theme) {
        this.name = name;
        this.theme = theme;
    }

    public Series(long id, String name, Theme theme) {
        this.id = id;
        this.name = name;
        this.theme = theme;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
