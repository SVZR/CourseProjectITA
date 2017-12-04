package entity;

public class Coin {

    private long id;
    private String name;
    private Series series;
    private String releaseDate;
    private String designer;
    private String mintedBy;
    private String descriptionObverse;
    private String descriptionRevers;
    private String image;

    public Coin() {}

    public Coin(long id, String name, Series series, String releaseDate, String designer, String mintedBy, String descriptionObverse, String descriptionRevers, String image) {
        this.id = id;
        this.name = name;
        this.series = series;
        this.releaseDate = releaseDate;
        this.designer = designer;
        this.mintedBy = mintedBy;
        this.descriptionObverse = descriptionObverse;
        this.descriptionRevers = descriptionRevers;
        this.image = image;
    }

    public Coin(String name, Series series, String releaseDate, String designer, String mintedBy, String descriptionObverse, String descriptionRevers, String image) {
        this.name = name;
        this.series = series;
        this.releaseDate = releaseDate;
        this.designer = designer;
        this.mintedBy = mintedBy;
        this.descriptionObverse = descriptionObverse;
        this.descriptionRevers = descriptionRevers;
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

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getMintedBy() {
        return mintedBy;
    }

    public void setMintedBy(String mintedBy) {
        this.mintedBy = mintedBy;
    }

    public String getDescriptionObverse() {
        return descriptionObverse;
    }

    public void setDescriptionObverse(String descriptionObverse) {
        this.descriptionObverse = descriptionObverse;
    }

    public String getDescriptionRevers() {
        return descriptionRevers;
    }

    public void setDescriptionRevers(String descriptionRevers) {
        this.descriptionRevers = descriptionRevers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
