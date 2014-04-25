/*
 * B. Manage your Energy
 * Round 1A 2013
 */
package jam.y2013.r1a;

/**
 *
 * @author ps
 */
import java.io.*;
import java.util.*;
import java.math.*;

public class B_Energy {

    static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2013//r1//B-sample.in";

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));

        int T = Integer.parseInt(in.nextLine()); // The first line of the input gives the number of test cases, T. T test cases follow. 
        for (int t = 1; t <= T; t++) {

            /* Input
             Each test case is described by two lines. 
             The first contains three integers: 
             E, the maximum (and initial) amount of energy, 
             R, the amount you regain after each activity, and 
             N, the number of activities planned for the day. 
             The second line contains N integers vi, describing the values of the activities 
             you have planned for today.
             */
            
            int E = in.nextInt();
            int R = in.nextInt();
            int N = in.nextInt();
            int Y = 0;
            
            int vi[] = new int[N];
            for (int i = 0; i<N; i++)
            {
                vi[i] = in.nextInt();
            }
            
            // strategy: allocate max E towards highest vi
            //
            // 2 options:
            // Y = N * R + sum(vi * e) where e<=E 
            // maximize Y
            
            System.out.println("Case #" + t + ": " + Y);
        }
        in.close();
        out.close();
    }

}
