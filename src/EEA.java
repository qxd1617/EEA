import java.util.*;

public class EEA {
    public static void main(String[] args) {
        Stack<Integer> qStack = new Stack<Integer>();
        int x1, y1, x, y, a, b, q, r;

        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        int cycles = 0;

        while (b != 0) {
            q = a / b;
            r = a % b;
            a = b;
            b = r;
            qStack.push(q);
            cycles++;
        }
        if (a != 1) {
            try {
                throw new Exception("GCD of (A,B) is not 1.");
            } catch (Exception E) {
                System.out.println(E);
            }
        } else {
            x1 = a;
            y1 = b;
            y = 0;
            x = 0;
            while (cycles != 0) {
                y = x1 - (y1 * qStack.pop());
                x = y1;
                y1 = y;
                x1 = x;
                cycles--;
            }
            System.out.println("Coefficient for big Integer: " + y);
            System.out.println("Coefficient for small Integer: " + x);
        }
    }
}