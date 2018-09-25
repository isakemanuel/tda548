package samples.types.inheritance;

import samples.inheritance.ISayable;
import samples.types.inheritance.Car;

/*
 *  Strange class for a talking Car, sub class to Car
 *  Used to illustrate types, see SubtypingInheritance
 */
public class TalkingCar extends Car implements ISayable {

    @Override
    public String say() {
        return "Honk honk";
    }
}
