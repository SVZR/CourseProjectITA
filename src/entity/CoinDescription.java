package entity;

public class CoinDescription {
    private long id;
    private Coin coin;
    private Metal metal;
    private long denomination;
    private long mintage;
    private double weight;
    private double diameter;
    private String imageObverse;
    private String imageReverse;

    public CoinDescription() {
    }

    public CoinDescription(long id) {
        this.id = id;
    }

    public CoinDescription(Coin coin, Metal metal, long denomination, long mintage, double weight, double diameter, String imageObverse, String imageReverse) {
        this.coin = coin;
        this.metal = metal;
        this.denomination = denomination;
        this.mintage = mintage;
        this.weight = weight;
        this.diameter = diameter;
        this.imageObverse = imageObverse;
        this.imageReverse = imageReverse;
    }

    public CoinDescription(long id, Coin coin, Metal metal, long denomination, long mintage, double weight, double diameter, String imageObverse, String imageReverse) {
        this.id = id;
        this.coin = coin;
        this.metal = metal;
        this.denomination = denomination;
        this.mintage = mintage;
        this.weight = weight;
        this.diameter = diameter;
        this.imageObverse = imageObverse;
        this.imageReverse = imageReverse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public Metal getMetal() {
        return metal;
    }

    public void setMetal(Metal metal) {
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
