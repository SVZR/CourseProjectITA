package dto;

public class ViewCoinAmountInCollectionDto {
    private long coinDescriptionId;
    private long amount;

    public ViewCoinAmountInCollectionDto(long coinDescriptionId, long amount) {
        this.coinDescriptionId = coinDescriptionId;
        this.amount = amount;
    }

    public long getCoinDescriptionId() {
        return coinDescriptionId;
    }

    public void setCoinDescriptionId(long coinDescriptionId) {
        this.coinDescriptionId = coinDescriptionId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
