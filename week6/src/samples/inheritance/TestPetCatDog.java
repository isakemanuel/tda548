package samples.inheritance;

import static java.lang.System.out;

/*
     Test classes with inheritance
 */
public class TestPetCatDog {

    public static void main(String[] args) {
        new TestPetCatDog().program();
    }

    void program() {
        //Pet p = new Pet("Any", 0);     // No, Pet abstract!

        Dog d = new Dog("Fido", 3);
        Cat c = new Cat("Missan", 4, false);

        out.println(d);
        out.println(c);

        out.println(d.getName());    // Use inherited methods
        out.println(c.getAge());

        out.println(d.say());
        out.println(c.say());

        out.println(c.isEvil());
        // d.isEvil();             // No such method in Dog

    }


}
