package samples.inheritance;

/*
 *  Specific animal, sub class to Pet.
 */
public class Dog extends Pet {

    public Dog(String name, int age) {
        super(name, age);    // Must call constructor of base class first to set the data
    }

    @Override
    public String say(){
        return "Voff";
    }  // Own version of say

    @Override
    public String toString() {
        return "Dog{" +
                getName() + "," + getAge() + '}';  // Own version of toString
    }
}
