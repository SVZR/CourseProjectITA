package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewCoinForAddingDto {
    private long id;
    private String coinName;
    private LocalDate releaseDate;
    private String designer;
    private String mintedBy;
    private String descriptionObverse;
    private String descriptionReverse;
}
