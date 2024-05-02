package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello")
                .orElse("default value");

        System.out.println(value);

        String defaultValue = "default value";
        Optional.ofNullable(null)
                .orElse(defaultValue);
        System.out.println(defaultValue);

        Supplier<IllegalArgumentException> errorMessage = () -> new IllegalArgumentException("Error message");
        Object value2 = Optional.ofNullable("Hi!")
                .orElseThrow(errorMessage);
        System.out.println(value2);

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        ()-> System.out.println("Cannot send email"));



    }
}
