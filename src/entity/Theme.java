package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Theme {

    private long id;
    private String name;
    private Country country;
    private long amount;

    public Theme(long id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Theme(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Theme(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
