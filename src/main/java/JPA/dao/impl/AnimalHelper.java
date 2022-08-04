package JPA.dao.impl;

import JPA.dao.animalDao;
import JPA.entity.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AnimalHelper implements animalDao {

    EntityManagerFactory emf;
    EntityManager em;

    public AnimalHelper() {
        emf = Persistence.createEntityManagerFactory("mohr");
        em = emf.createEntityManager();
    }

    @Override
    public boolean add(Animal animal) {
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
        emf.close();
        return true;
    }

    @Override
    public Animal update(Animal animal) {
        em.getTransaction().begin();
        animal.setAge(animal.getAge()+1);
        animal.setId(1);
        em.refresh(animal);
        em.getTransaction().commit();
        emf.close();
        return animal;
    }

    @Override
    public boolean delete(Animal animal) {
        em.getTransaction().begin();
        em.remove(animal);
        em.getTransaction().commit();
        emf.close();
       return true;
    }

    @Override
    public Animal get(int id) {
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class,id);
        em.getTransaction().commit();
        emf.close();
        return  animal;
    }
}
