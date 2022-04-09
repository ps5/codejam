/*
 * CodeJam 2014
 * Round 1A 4/25/2014
 */
package jam.y2014.r1a;

/**
 *
 * @author shiryap
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class A_large {

    static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1a//A-large-practice.in";

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));

        int T = in.nextInt();
        int t = 0;
        while (t++ < T) {
            int N = in.nextInt();
            int L = in.nextInt();
            in.nextLine();

            System.out.println("Case #" + t + "  N = " + N + "  L = " + L);
            long f1[] = new long[N];
            long f2[] = new long[N];
            readFlow(f1);
            readFlow(f2);
            //display(f1);
            //display(f2);

            Arrays.sort(f1);
            Arrays.sort(f2);

            long sol = -1;
            for (int i = 0; i < f1.length; i++) {
                for (int j = 0; j < f2.length; j++) {
                    long k = f1[i] ^ f2[j]; // key
                    long f[] = new long[N];
                    for (int ii = 0; ii < f1.length; ii++) {
                        f[ii] = f1[ii] ^ k;
                    }
                    Arrays.sort(f);
                    if (Arrays.equals(f2, f)) {
                        if (Long.bitCount(k) < Long.bitCount(sol)) {
                            sol = k;
                        }
                        //break;
                    }

                }
                if (sol != -1) {
                    break;
                }
            }

            out.print("Case #" + t + ": ");

            if (sol == -1) {
                out.println("NOT POSSIBLE");
                System.out.println("NOT POSSIBLE");
            } else {
                out.println(Long.bitCount(sol));
                System.out.println(Long.bitCount(sol));
            }

        }

        in.close();
        out.close();

    }

    public static void display(long b[]) {
        for (long i : b) {
            System.out.print(Long.toBinaryString(i) + " ");
        }

        System.out.println();
    }

    public static void readFlow(long n[]) {
        String s[] = in.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            String ss = s[i];
            n[i] = 0;
            long r = 1;
            for (int j = ss.length() - 1; j >= 0; j--) {
                n[i] += ss.charAt(j) == '1' ? r : 0;
                r *= 2;

            }

        }

    }

}
