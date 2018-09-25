package samples.inheritance.initialization;

/*
 *   Static is at class load time!! Done once!
 */
public class InstantiateInherit {

    public static void main(String[] args) throws NoSuchFieldException {
        new InstantiateInherit().program();
    }

    void program() {
        A a = new A(3, 4);
    }
}

