package io.chico.functional.sample;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Francisco Almeida
 */
public class HighOrderFunctionIllustration {

    public static void main(String[] args) {
        Supplier<String> xFormOperation = createCombinationAndTransform("Chico", "Almeida", String::toUpperCase);

        System.out.println(xFormOperation.get());
    }

    public static Supplier<String> createCombinationAndTransform(String a, String b, Function<String, String> transformer) {
        return () -> {
            String aa = a;
            String bb = b;

            if (transformer == null) {
                aa = transformer.apply(a);
                bb = transformer.apply(b);
            }

            return aa + bb;
        };
    }
}
