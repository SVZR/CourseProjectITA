package entity;

public class MyCollection {
    private long id;
    private User user;
    private CoinDescription coinDescription;
    private long amount;

    public MyCollection() {}

    public MyCollection(long id, User user, CoinDescription coinDescription, long amount) {
        this.id = id;
        this.user = user;
        this.coinDescription = coinDescription;
        this.amount = amount;
    }

    public MyCollection(User user, CoinDescription coinDescription, long amount) {
        this.user = user;
        this.coinDescription = coinDescription;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CoinDescription getCoinDescription() {
        return coinDescription;
    }

    public void setCoinDescription(CoinDescription coinDescription) {
        this.coinDescription = coinDescription;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
