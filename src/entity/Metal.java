package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Metal {

    private long id;
    private String name;

    public Metal(String name) {
        this.name = name;
    }
}
