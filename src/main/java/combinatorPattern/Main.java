package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                /*
                If an attribute don't respect the validation
                Will print the enum and throw an exception
                */
                "Alice",
                "alice@gmail.com",
                "+0898787879878",
                LocalDate.of(2000, 1, 1)
        );

        //System.out.println(new CustomerValidatorService().isValid(customer));
        // if valid we can store customer in db


        //Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
