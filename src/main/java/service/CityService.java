package service;

import model.City;

public interface CityService {


    Iterable<City> fillAll();


    void delete(Long id);

    Iterable<City> fillBookByName(String name);

    void save(City city);
    City findBook(Long id);
}
