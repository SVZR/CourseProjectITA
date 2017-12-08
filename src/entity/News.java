package entity;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class News {
    private long id;
    private String text;
    private LocalDateTime releaseDate;

    public News(long id, String text, LocalDateTime releaseDate) {
        this.id = id;
        this.text = text;
        this.releaseDate = releaseDate;
    }

    public News(String text, LocalDateTime releaseDate) {
        this.text = text;
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }
}
