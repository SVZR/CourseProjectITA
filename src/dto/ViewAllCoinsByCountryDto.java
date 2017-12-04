package dto;

public class ViewAllCoinsByCountryDto {
    private long id;
    private String name;
    private long seriesId;
    private String image;

    public ViewAllCoinsByCountryDto(long id, String name, long seriesId, String image) {
        this.id = id;
        this.name = name;
        this.seriesId = seriesId;
        this.image = image;
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

    public long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(long seriesId) {
        this.seriesId = seriesId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

