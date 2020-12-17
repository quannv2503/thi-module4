package service;

import model.Nation;

import java.util.List;

public interface NationService {
    Iterable<Nation> findAll();

    void save(Nation nation);

}
