package samples.inheritance;

/*
 *  A specific animal sub class to Pet
 */
public class Cat extends Pet {

    private boolean isEvil;   // Unique to Cats

    public Cat(String name, int age, boolean isEvil) {
        super(name, age);      // Must call constructor of base class first
        this.isEvil = isEvil;  // Set unique
    }

    @Override
    public String say() {
        return "Mjau";
    }  // Own version of say

    public boolean isEvil() {
        return isEvil;
    }  // Unique to Cats

    @Override
    public String toString() {
        return "Cat{" +
                getName() + "," + getAge() + '}';  // Own version of toString
    }
}
