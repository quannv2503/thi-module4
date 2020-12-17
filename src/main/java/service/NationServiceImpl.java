package service;

import model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import repository.NationRepository;

import java.util.List;

public class NationServiceImpl implements NationService {
    @Autowired
    NationRepository repository;

    public Iterable<Nation> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Nation category) {
        repository.save(category);
    }


}
