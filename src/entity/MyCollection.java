package entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MyCollection {

    private long id;
    private User user;
    private CoinDescription coinDescription;
    private long amount;
    private String name;

    public MyCollection(long id, User user, CoinDescription coinDescription, long amount) {
        this.id = id;
        this.user = user;
        this.coinDescription = coinDescription;
        this.amount = amount;
    }
}
