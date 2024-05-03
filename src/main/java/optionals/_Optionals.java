package optionals;

import java.nio.file.OpenOption;
import java.util.Optional;

public class _Optionals {
    public static void main(String[] args) {
        System.out.println("Testing Optional");
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());

        System.out.println("Optional of");
        Optional<Object> hello = Optional.of("hello");
        //cause exception:
        //Optional<String> hello = Optional.of(null);
        System.out.println("hello.isPresent: " + hello.isPresent());
        System.out.println("hello.isEmpty: "+ hello.isEmpty());

        //When no sure if the value will be a nullable or not:
        //Use Optional.ofNullable
        System.out.println("Optional.ofNullable example");
        Optional<String> hello1 = Optional.ofNullable(null);
        System.out.println(hello1.isPresent());
        System.out.println(hello1.isEmpty());

        System.out.println("orElse example");
        String orElse = hello1.orElse("world");
        System.out.println(orElse);

        System.out.println("Optional with functional programming");
        System.out.println("Using orElse");
        Optional<String> hello2 = Optional.ofNullable("hello");
        String orElse2 = hello2.map(String::toUpperCase)
                .orElse("world");
        System.out.println(orElse2);

        System.out.println("Optional using orElseGet");
        Optional<String> hello3 = Optional.ofNullable(null);
        String orElseGet = hello3.map(String::toUpperCase)
                .orElseGet(() -> {
                            //... extra computation to retrieve the value
                            return "world";
                        }
                );
        System.out.println(orElseGet);

//        System.out.println("orElseThrow");
//        Optional<String> hello4 = Optional.ofNullable(null);
//        String orElseThrow = hello4
//                .map(String::toUpperCase)
//                .orElseThrow(IllegalArgumentException::new);
//
//        System.out.println(orElseThrow);

        System.out.println("ifPresent");
        //Takes actual value of the Optional if it's present
        Optional<String> hello5 = Optional.ofNullable("hello"); //change for null to test ifPresentOrElse
        hello5.ifPresent(System.out::println);

        System.out.println("ifPresentOrElse");
        hello5.ifPresentOrElse(System.out::println, () -> System.out.println("world"));

        Person james = new Person("james", "JAMES@gmail.com");
        System.out.println(james.getEmail());

        Person personWithNullEmail = new Person("personWithNullEmail", null);

        String not_provided = personWithNullEmail
                .getEmail()
                .map(String::toLowerCase)
                .orElse("email not provided");

        System.out.println(not_provided);

        System.out.println("Wrap optionals yourself:");
        if (james.getEmail().isPresent()){
            String email = james.getEmail().get();
            System.out.println(email.toLowerCase());
        }else {
            System.out.println("email not provided");
        }
    }
    static class Person{
        private final String name;
        private final String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }

        //Let the client know that email, might be nullable
        public Optional<String> getEmail() {
            return Optional.ofNullable(email);
        }
    }
}
