package service;

import dao.CollectionDao;
import dao.CountryDao;
import dto.CreateNewCountryDto;
import dto.ViewAllCountriesDto;
import dto.ViewCountryInfoDto;
import dto.ViewCountryWithCoinsAmountDto;
import entity.Country;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public List<ViewCountryWithCoinsAmountDto> getCountriesWithAmountOfUserCoins(long userId) {
        return CollectionDao.getInstance().findCountryNamesAndSumCoinsInCollection(userId).stream()
                .map(myCollection -> new ViewCountryWithCoinsAmountDto(myCollection.getId(),
                        myCollection.getName(), myCollection.getAmount()))
        .collect(Collectors.toList());
    }
}
