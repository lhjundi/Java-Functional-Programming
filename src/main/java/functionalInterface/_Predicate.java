package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        System.out.println( //Without Predicate
                        isPhoneNumberValid("07000000000") + " " +
                        isPhoneNumberValid("0700000000") + " " +
                        isPhoneNumberValid("09009877300")
                );

        System.out.println( //With Predicate
                  isPhoneNumberValidPredicate.test("07000000000") + " "
                + isPhoneNumberValidPredicate.test("0700000000") + " "
                + isPhoneNumberValidPredicate.test("09009877300")
        );
        System.out.println(
                "Is Phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate
                                .and(containsNumber3)
                                .test("07000000000"));
        System.out.println(
                "Is Phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate
                                .and(containsNumber3)
                                .test("0700000000"));

        System.out.println(
                "Is Phone number valid and contains number 3 = " +
                isPhoneNumberValidPredicate
                        .and(containsNumber3)
                        .test("09009877300"));

        System.out.println(
                "Is Phone number valid or contains number 3 : " +
                isPhoneNumberValidPredicate
                        .or(containsNumber3)
                        .test("07000000000")
        );

        System.out.println(
                "Phone have a number 3 and email have @ : " +
                        isEmailAndPhoneValidBiPredicate
                                .test(
                                        "09009877300", "lhjundi@proton.me"
                                )
        );

    }


    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate =
            phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length()==11;

    static Predicate<String> containsNumber3 =
            phoneNumber -> phoneNumber.contains("3");

    static BiPredicate<String, String> isEmailAndPhoneValidBiPredicate=
            (phone, email) -> phone.contains("3") && email.contains("@");

}
