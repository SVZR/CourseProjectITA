package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class Coin {

    private long id;
    private String name;
    private Series series;
    private LocalDate releaseDate;
    private String designer;
    private String mintedBy;
    private String descriptionObverse;
    private String descriptionRevers;
    private long amount;

    public Coin(long id, String name, Series series, LocalDate releaseDate, String designer, String mintedBy, String descriptionObverse, String descriptionRevers) {
        this.id = id;
        this.name = name;
        this.series = series;
        this.releaseDate = releaseDate;
        this.designer = designer;
        this.mintedBy = mintedBy;
        this.descriptionObverse = descriptionObverse;
        this.descriptionRevers = descriptionRevers;
    }

    public Coin(String name, Series series, LocalDate releaseDate, String designer, String mintedBy, String descriptionObverse, String descriptionRevers) {
        this.name = name;
        this.series = series;
        this.releaseDate = releaseDate;
        this.designer = designer;
        this.mintedBy = mintedBy;
        this.descriptionObverse = descriptionObverse;
        this.descriptionRevers = descriptionRevers;
    }
}
