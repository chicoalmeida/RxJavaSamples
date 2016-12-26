package io.chico;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        String transform = "ABC";

        System.out.println(reverse(transform));

    }

    public static String reverse(String a) {
        StringBuilder reverse = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            System.out.println(a.charAt(i));
            reverse.append(a.charAt(i));
        }
        return reverse.toString();
    }
}

