package dto;

import java.time.LocalDateTime;

public class ViewAllNewsDto {
    private long id;
    private String text;
    private LocalDateTime releaseDate;

    public ViewAllNewsDto(long id, String text, LocalDateTime releaseDate) {
        this.id = id;
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
