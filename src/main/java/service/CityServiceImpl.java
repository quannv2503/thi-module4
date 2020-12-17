package service;

import model.City;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CityRepository;
import service.CityService;

public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public Iterable<City> fillAll() {
        return cityRepository.findAll();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public City findBook(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(id);
    }

    @Override
    public Iterable<City> fillBookByName(String name) {
        return cityRepository.findBooksByNameContaining(name);
    }

}
