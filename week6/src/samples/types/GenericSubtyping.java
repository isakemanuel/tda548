package samples.types;


import samples.types.inheritance.Car;
import samples.types.inheritance.TalkingCar;

/*
 *  Using super/sub types with collections
 */
public class GenericSubtyping {

    public static void main(String[] args) {
        new GenericSubtyping().program();
    }

    void program() {

        Box<String> sm = new Box<>();
        sm.toRemember = "remember";

        Box<Integer> im = new Box<>();
        im.toRemember = 1;

        //im.toRemember = 1.0;      // Nope!

        // TalkingCar <: Car *but* Box<TalkingCar <: Box<Car>
        Box<TalkingCar> tcb = new Box<>();
        Box<Car> cb;

        //cb = tcb;         // No super/subtype!
        //tcb = cb;


    }

    // A generic class/type
    class Box<T> {
        T toRemember;    // T is any reference type
    }

    // Had similar before
    <T> boolean contains(T[] arr, T toFind) {
        for (T t : arr) {
            if (t.equals(toFind)) {   // NOTE: Depends on implementation of equals
                return true;
            }
        }
        return false;
    }



}
