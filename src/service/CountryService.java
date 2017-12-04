package service;

import dao.CountryDao;
import dto.CreateNewCountryDto;
import dto.ViewAllCountriesDto;
import dto.ViewCountryInfoDto;
import entity.Country;

import java.util.List;
import java.util.stream.Collectors;

public final class CountryService {

    private static CountryService INSTANCE = null;

    private CountryService() {}

    public static CountryService getInstance() {
        if (INSTANCE == null) {
            synchronized (CountryService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CountryService();
                }
            }
        }
        return INSTANCE;
    }

    public long createNewCountry(CreateNewCountryDto dto) {
        return CountryDao.getInstance().create(new Country(dto.getName())).getId();
    }

    public List<ViewAllCountriesDto> getAllCountries() {
        return CountryDao.getInstance().findAll().stream()
                .map(countryEntity -> new ViewAllCountriesDto(countryEntity.getId(), countryEntity.getName()))
                .collect(Collectors.toList());
    }

    public ViewCountryInfoDto getCountryById(long id) {
        Country country = CountryDao.getInstance().findById(id).get();
        return new ViewCountryInfoDto(country.getId(), country.getName());
    }
}
