package playground;

import java.sql.SQLOutput;

public class JavaPlayground {

    public static void main (String args[]) {
        System.out.println("Hello, java");

        System.out.println(Person.N_EYES); // class level functionality - access the field from class person without an instance of the class
    }

}

class Person {

    public static final int N_EYES = 2;


}
