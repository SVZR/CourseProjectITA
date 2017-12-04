package dto;

import java.util.List;

public class ViewCoinByIdDto {
    private String country;
    private String theme;
    private String series;
    private String coinName;
    private String releaseDate;
    private String designer;
    private String mintageBy;
    private List<ViewCoinDescriptionDto> coinDescription;
    private String descriptionObverse;
    private String descriptionReverse;

    public ViewCoinByIdDto(String country, String theme, String series, String coinName, String releaseDate, String designer, String mintageBy, List<ViewCoinDescriptionDto> coinDescription, String descriptionObverse, String descriptionReverse) {
        this.country = country;
        this.theme = theme;
        this.series = series;
        this.coinName = coinName;
        this.releaseDate = releaseDate;
        this.designer = designer;
        this.mintageBy = mintageBy;
        this.coinDescription = coinDescription;
        this.descriptionObverse = descriptionObverse;
        this.descriptionReverse = descriptionReverse;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
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

    public String getMintageBy() {
        return mintageBy;
    }

    public void setMintageBy(String mintageBy) {
        this.mintageBy = mintageBy;
    }

    public List<ViewCoinDescriptionDto> getCoinDescription() {
        return coinDescription;
    }

    public void setCoinDescription(List<ViewCoinDescriptionDto> coinDescription) {
        this.coinDescription = coinDescription;
    }

    public String getDescriptionObverse() {
        return descriptionObverse;
    }

    public void setDescriptionObverse(String descriptionObverse) {
        this.descriptionObverse = descriptionObverse;
    }

    public String getDescriptionReverse() {
        return descriptionReverse;
    }

    public void setDescriptionReverse(String descriptionReverse) {
        this.descriptionReverse = descriptionReverse;
    }
}
