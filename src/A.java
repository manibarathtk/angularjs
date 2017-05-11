/*
 * 1 <= t <=10
1 <= n<=40

              a*b
lcm(a,b) = ---------- 
            gcd(a,b)
 */
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class A {

    final static int N = 40;

    static Map<Integer, String> messages = new HashMap<>();

    static {
        messages.put(0, "Euler - difference");
        messages.put(1, "modulo - recursive");
        messages.put(2, "modulo - iterative");
        messages.put(3, "BigInteger implementation");
    }

    private static long GCD0(long x, long y) {
        while (x != y) {
            if (x > y) {
                x -= y;
            } else {
                y -= x;
            }
        } 
        return x;
    }

    private static long GCD1(long x, long y) {
        if (x % y == 0) {
            return y;
        }
        return GCD1(y, x % y);
    }

    private static long GCD2(long x, long y) {
        long aux;
        while (x % y != 0) {
            aux = y;
            y = x % y;
            x = aux;
        }
        return y;
    }

    private static long GCD3(long x, long y) {
        BigInteger xx = BigInteger.valueOf(x);
        BigInteger yy = BigInteger.valueOf(y);
        return xx.gcd(yy).longValue();
    }

    private static void doIt(int pos) throws Exception {

        System.out.print("\n" + messages.get(pos));
        printSpaces(25, messages.get(pos).length());

        Class cls = Class.forName("A");
        Object obj = cls.newInstance();
        Method method = cls.getDeclaredMethod("GCD" + pos, long.class,
                long.class);

        long start = System.nanoTime();

        long p = 1;
        for (int i = 2; i <= N; i++) {
            p = (p * i) / (long) method.invoke(obj, p, i);
        }
        long stop = System.nanoTime();
        System.out.println("\tTime: " + (stop - start) / 1000 + " microseconds");
        System.out.println(p);
    }

    private static void printSpaces(int total, int actualLength) {
        for (int i = 0; i < total - actualLength; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) throws Exception {
       // doIt(0);
        doIt(1);
        doIt(2);
        doIt(3);
    }
}