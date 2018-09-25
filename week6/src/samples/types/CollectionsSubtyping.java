package samples.types;


import samples.inheritance.Cat;
import samples.inheritance.Dog;
import samples.inheritance.ISayable;
import samples.inheritance.Pet;

import java.util.ArrayList;
import java.util.List;

/*
 *  Using super/sub types with collections
 */
public class CollectionsSubtyping {

    public static void main(String[] args) {
        new CollectionsSubtyping().program();
    }

    void program() {
        Dog d = new Dog("Fido", 3);
        Cat c = new Cat("Missan", 4, false);

        List<Pet> pets = new ArrayList<>();
        pets.add(d);             // Ok, Dog is a Pet
        pets.add(c);             // Ok, Cat is a Pet
        pets.get(0).getName();

        List<ISayable> sayables = new ArrayList<>();
        sayables.add(d);      // Ok, Dog is sayable
        sayables.add(c);       // Ok, Cat is sayable
        sayables.get(0).say();
        //sayables.get(0).getName();   // No such method

        //sayables = pets;    // No, generic types, no subtype relation!
        //pets = sayables;

        //pets.add(sayables.get(0));  // A sayable may not be a Pet (see TalkingCar)!
        sayables.add(pets.get(0));    // Any pet is sayable

        sayables.addAll(pets);
        //pets.addAll(sayables);

        for (ISayable s : sayables) {
            if (s instanceof Pet) {    // Check if object is Pet or subclass to
                pets.add((Pet) s);
            }
        }
    }

}
