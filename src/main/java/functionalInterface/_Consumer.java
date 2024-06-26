package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {

        Custumer maria = new Custumer("Maria", "99999");
        //Normal Java Function
        greetCustumer(maria);

        //Consumer Functional Interface
        //A consumer takes one argument and return nothing
        //It's like a void function
        greetCustumerConsumer.accept(maria);

        greetCustumerBiConsumer.accept(maria,true);
        greetCustumerBiConsumer.accept(maria, false);
    }

    static BiConsumer<Custumer, Boolean> greetCustumerBiConsumer =
            (custumer, showPhoneNumber) -> System.out.println(
                    "Hello " + custumer.custumerName
                    + " , thanks for registering phone number "
                    + (showPhoneNumber? custumer.custumerPhoneNumber : "******")
            );

    static Consumer<Custumer> greetCustumerConsumer =
            custumer -> System.out.println(
                    "Hello " + custumer.custumerName +
                            " , thanks for registering phone number " +
                            custumer.custumerPhoneNumber
            );
    static void greetCustumer(Custumer custumer){
        System.out.println(
                "Hello " + custumer.custumerName +
                        " , thanks for registering phone number " +
                        custumer.custumerPhoneNumber
        );
    }
    static class Custumer{
        private final String custumerName;
        private final String custumerPhoneNumber;

        public Custumer(String custumerName, String custumerPhoneNumber) {
            this.custumerName = custumerName;
            this.custumerPhoneNumber = custumerPhoneNumber;
        }
    }
}
