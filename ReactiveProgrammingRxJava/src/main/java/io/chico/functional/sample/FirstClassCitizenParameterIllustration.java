package io.chico.functional.sample;

import java.util.function.Function;

/**
 * @author Francisco Almeida
 */
public class FirstClassCitizenParameterIllustration {

    public static void main(String[] args) {
        System.out.println(concatAndTransform("Chico ", "Almeida", String::toUpperCase));
    }

    public static String concatAndTransform(String a, String b, Function<String, String> stringTransform) {
        if (stringTransform != null) {
            a = stringTransform.apply(a);
            b = stringTransform.apply(b);
        }
        return a + b;
    }
}
