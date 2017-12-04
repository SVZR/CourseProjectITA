package dto;

public class CreateNewCountryDto {

    private String name;

    public CreateNewCountryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
