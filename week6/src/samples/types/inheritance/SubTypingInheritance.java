package samples.types.inheritance;

import samples.inheritance.*;

import static java.lang.System.out;

/*
 *  Inheritance and subtyping
 *
 *  Classes Pet, Cat and Dog from sample/inheritance
 */
public class SubTypingInheritance {

    public static void main(String[] args) {
        new SubTypingInheritance().program();
    }

    void program() {

        Dog d = new Dog("Fido", 3);
        Cat c = new Cat("Missan", 4, false);

        //d = c;      // No, no subtype relation!
        //c = d;
        //d = (Dog) c;   // No, no subtype relation!
        //c = (Cat) d;

        // If A extends to B then A <: B (i.e. A is subtype to B)
        Pet p1 = d;       // Ok Dog is subtype to Animal
        Pet p2 = c;          // .. and so is Cat

        //d = (Dog) p2;   // Compiles but exception later
        d = (Dog) p1;     // Ok
        //c = (Cat) p1;   // Compiles but exception later

        // If A implements B then A <: B
        ISayable s1 = d;   // Ok
        ISayable s2 = c;

        d = (Dog) s1;    // Ok
        c = (Cat) s2;    // Ok

        Car car1 = new Car();
        ISayable s3 = (ISayable) car1;   // Compiles, why is this allowed ??? ...

        car1 = new TalkingCar();          // ...because talkingCar is subtype to Car
        ISayable s4 = (ISayable) car1;     // ... sub class may (does) implement!
        out.println(s4.say());




    }


}
