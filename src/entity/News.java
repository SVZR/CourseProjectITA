package entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class News {

    private long id;
    private String headline;
    private String text;
    private LocalDateTime releaseDate;

    public News(String headline, String text, LocalDateTime releaseDate) {
        this.headline = headline;
        this.text = text;
        this.releaseDate = releaseDate;
    }
}
