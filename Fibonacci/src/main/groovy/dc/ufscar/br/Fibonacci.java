package dc.ufscar.br;

/**
 * Created by wpstudart on 15/07/17.
 */

public class Fibonacci {

    private int n;

    public int Fibonacci(int n){

        this.n = n;
        int pre = 0;
        int fib = 1;
        int aux = 1;

        if (n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        } else {
            for (int i = 2; i <= n; i++) {

                fib = pre + aux;
                pre = aux;
                aux = fib;
            }

            return fib;
        }
    }
}
