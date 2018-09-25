package samples.types;

/*
        Any class may have multiple super or subtypes
        Nothing to run

 */
public class MultipleSuperSubTypes {

    public interface IX {

    }

    public interface IY {

    }

    public class A {

    }

    // Multiple supertypes
    public class B extends A implements IX, IY {

    }

    // Multiple subtypes to IX
    public class D1 implements IX {

    }

    public class D2 implements IX {

    }

    public class D3 implements IX {

    }
}
