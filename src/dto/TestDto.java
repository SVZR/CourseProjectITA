package dto;

import java.util.HashMap;

public class TestDto {
    private HashMap<Long, Long> cdIdAmount;

    public TestDto(HashMap<Long, Long> cdIdAmount) {
        this.cdIdAmount = cdIdAmount;
    }

    public HashMap<Long, Long> getCdIdAmount() {
        return cdIdAmount;
    }

    public void setCdIdAmount(HashMap<Long, Long> cdIdAmount) {
        this.cdIdAmount = cdIdAmount;
    }
}
