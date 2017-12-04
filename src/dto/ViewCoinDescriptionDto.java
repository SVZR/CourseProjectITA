package dto;

public class ViewCoinDescriptionDto {
    private long id;
    private String metal;
    private long denomination;
    private double weight;
    private double diameter;
    private long mintage;
    private String imageObverse;
    private String imageReverse;

    public ViewCoinDescriptionDto(long id, String metal, long denomination, double weight, double diameter, long mintage, String imageObverse, String imageReverse) {
        this.id = id;
        this.metal = metal;
        this.denomination = denomination;
        this.weight = weight;
        this.diameter = diameter;
        this.mintage = mintage;
        this.imageObverse = imageObverse;
        this.imageReverse = imageReverse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public long getMintage() {
        return mintage;
    }

    public void setMintage(long mintage) {
        this.mintage = mintage;
    }

    public String getImageObverse() {
        return imageObverse;
    }

    public void setImageObverse(String imageObverse) {
        this.imageObverse = imageObverse;
    }

    public String getImageReverse() {
        return imageReverse;
    }

    public void setImageReverse(String imageReverse) {
        this.imageReverse = imageReverse;
    }
}
