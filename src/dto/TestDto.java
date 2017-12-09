package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestDto {

    private HashMap<Long, Long> cdIdAmount;
}
