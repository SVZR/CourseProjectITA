package dto;

public class ViewAllYearsDto {

    private long id;
    private int year;

    public ViewAllYearsDto(long id, int year) {
        this.id = id;
        this.year = year;
    }

    public ViewAllYearsDto(int year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
