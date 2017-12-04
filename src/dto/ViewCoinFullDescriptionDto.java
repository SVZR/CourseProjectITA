package dto;

public class ViewCoinFullDescriptionDto {
    private long id;
    private String name;
    private String description;
    private String metal;
    private long denomination;
    private long mintage;
    private long weight;
    private long diameter;
    private String image;

    public ViewCoinFullDescriptionDto(long id, String name, String description, String metal, long denomination, long mintage, long weight, long diameter, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.metal = metal;
        this.denomination = denomination;
        this.mintage = mintage;
        this.weight = weight;
        this.diameter = diameter;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public long getDenomination() {
        return denomination;
    }

    public void setDenomination(long denomination) {
        this.denomination = denomination;
    }

    public long getMintage() {
        return mintage;
    }

    public void setMintage(long mintage) {
        this.mintage = mintage;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getDiameter() {
        return diameter;
    }

    public void setDiameter(long diameter) {
        this.diameter = diameter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
