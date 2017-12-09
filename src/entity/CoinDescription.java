package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
}
