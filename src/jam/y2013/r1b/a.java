/*
 * A. Osmos
 * Round 1B 2013
 */

package jam.y2013.r1b;

/**
 *
 * @author ps
 */


import java.io.*;
import java.util.*;

public class a {

    static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2013//r1b//A-small-practice.in";
    //static final String filepath = System.getProperty("user.dir") + "//src//jam//y2013//r1b//A-sample.in";

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));

        int T = Integer.parseInt(in.nextLine()); // The first line of the input gives the number of test cases, T. T test cases follow. 
        for (int t = 1; t <= T; t++) {

            /* Input
              The first line of each test case gives the size of Armin's mote, A, 
              and the number of other motes, N. 
            The second line contains the N sizes of the other motes. 
            All the mote sizes given will be integers.
             */
            
            int A = in.nextInt();
            int N = in.nextInt();
            
            ArrayList<Integer> aa = new ArrayList<>(N);
            for (int i = 0; i<N; i++)
            {
                aa.add(in.nextInt());
            }
            
            // solve
            
            int Y = 0; // minimum number of operations
            if (A == 1) // can't eat anything
                Y = N;
            else
            {
            Collections.sort(aa);
            
            for (Integer a : aa) {
                if (a < A) 
                
                    A += a;
                else
                    if (a >= A+A-1) // too large - let's remove it (skip)
                {
                        Y++; // remove it
                    }
                else
                    { // add one smaller element than A
                        while (A <= a)
                        {
                            A += A - 1; 
                            Y++; // 1 operation
                        }
                    A += a; // eat element
                   
                }
            }
            }
            
            System.out.println("Case #" + t + ": " + Y);
            out.println("Case #" + t + ": " + Y);
            
            
        }
        in.close();
        out.close();
    }

}
