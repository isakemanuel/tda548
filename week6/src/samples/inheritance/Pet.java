package samples.inheritance;

/*
 *  Abstract base class for Pets
 *
 *  This class is abstract because we will never create Pet objects.
 *  We will create dogs, cats, etc. Also the class have an abstract
 *  method so it is thereby forced to be abstract.
 *
 *  This class is used to hold data and methods common to all Pets
 *  (i.e. avoid redundant code)
 *
 *  It also implements ISayable because all Pets should be able to say
 *  (hmm, not fully realistic, .. a snake)
 */
public abstract class Pet implements ISayable {

    private String name;   // Data common to all Pets
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }    // Methods that all Pets will have

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public abstract String say();  // Must have because we implement ISayble
                                   // But don't know yet what to say .. so make abstract!
                                   // Must be implemented by sub classes (else they will also be abstract)
}
