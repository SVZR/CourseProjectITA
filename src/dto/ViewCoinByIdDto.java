package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewCoinByIdDto {

    private String country;
    private String theme;
    private String series;
    private String coinName;
    private String releaseDate;
    private String designer;
    private String mintageBy;
    private List<ViewCoinDescriptionDto> coinDescription;
    private String descriptionObverse;
    private String descriptionReverse;
}
