package samples.inheritance.initialization;

import static java.lang.System.out;

public class A {

    private int i;
    private int j;
    private static B b = new B(1);

    public A(int i, int j ) {
        this.i = i;
        this.j = j;
        out.println("Instantiating A " + i + " " + j);
    }


}
