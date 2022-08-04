package JPA.logik;

import JPA.dao.impl.AnimalHelper;
import JPA.entity.Animal;

public class main {
    public static void main(String[] args) {
        AnimalHelper animalHelper = new AnimalHelper();
        Animal animal = Animal.builder()
                .name("jora")
                .age(15)
                .tail(false)
                .build();
        System.out.println(animalHelper.add(animal));
        System.out.println(animalHelper.get(1));
    }
}
