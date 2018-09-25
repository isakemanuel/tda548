package samples.inheritance.initialization;

import static java.lang.System.out;

class B extends A {

    public B(int i) {
        super(i, 9);
        out.println("Instantiating B " + i);
    }
}
