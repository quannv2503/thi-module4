package repository;

import model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
    Iterable<City> findBooksByNameContaining(String name);
}
