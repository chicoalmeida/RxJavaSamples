package io.chico;

/**
 * @author Francisco Almeida
 */
public class SideEffectIllustration {
    private int state  = 0;


    /*Pure function - Because it results can be predictive if you pass 5 a hundred times you'll always get the same result */

    /**
     *
     * Pure Functions always return the same result for a given set of parameter values.
     *  - No side effects caused by Class or Instace state
     *  - No side effects caused by I/O devices
     *  - No time related side effects
     *
     * */
    public int f1(int x){
        return x * 2;
    }
    /*Impure function - Because it results can' be predictive. Its results has side effect and can change around threats*/
    public int f2(int x){
        state = (++state % 3);
        return x * 2 + state;
    }

    public static void main(String[] args) {
        SideEffectIllustration v = new SideEffectIllustration();

        for (int i = 0; i < 100; i++) {
            if(v.f1(5) != 10)
                throw new IllegalStateException();
        }
        System.out.println("f1(5) = 10 for all calls");

        for (int i = 0; i < 100; i++) {
            System.out.println("f2(5) = "+ v.f2(5));
        }

    }
}
