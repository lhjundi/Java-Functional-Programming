package functionalInterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());

        //Supplier represents a supplier of results.
        System.out.println(
                getDBConnectionUrlSupplier.get()
        );

        System.out.println(
                getDBListOfConnectionUrlSupplier.get()
        );
    }
    static String getDBConnectionUrl(){ //Simply returns a value
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDBConnectionUrlSupplier =
            () -> "jdbc://localhost:5432/users";

    static Supplier<List<String>> getDBListOfConnectionUrlSupplier =
            () -> List.of(
                    "jdbc://localhost:5432/users",
                    "jdbc://localhost:5432/customers"
            );
}
