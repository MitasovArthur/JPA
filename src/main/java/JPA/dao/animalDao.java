package JPA.dao;

import JPA.entity.Animal;

public interface animalDao {
    boolean add(Animal animal);
    Animal update(Animal animal);
    boolean delete(Animal animal);
    Animal get(int id);
}
