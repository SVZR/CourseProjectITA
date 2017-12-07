package dto;

public class ViewCountryWithCoinsAmountDto {
    private long id;
    private String countryName;
    private long amountOfCoins;

    public ViewCountryWithCoinsAmountDto(long id, String countryName, long amountOfCoins) {
        this.id = id;
        this.countryName = countryName;
        this.amountOfCoins = amountOfCoins;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public long getAmountOfCoins() {
        return amountOfCoins;
    }

    public void setAmountOfCoins(long amountOfCoins) {
        this.amountOfCoins = amountOfCoins;
    }
}