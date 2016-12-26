package io.chico;

import java.util.function.BiFunction;

/**
 * @author Francisco Almeida
 */
public class FirstClassCitizenVariableIllustration {

    public static void main(String[] args) {
        BiFunction<String, String, String> concatFunction = (s, t) -> s + t;


        System.out.println(concatFunction.apply("Chico ", "Almeida"));

        BiFunction<String, Integer, Boolean> validation = FirstClassCitizenVariableIllustration::validate;

        System.out.println(validation.apply("Chico", 5));


    }

    public static String concatStrings(String a, String b) {
        return a + b;
    }

    public static Boolean validate(String a, Integer b) {
        return a.length() >= b;
    }
}
