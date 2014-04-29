/*
 * Round 1B 2013 - Practice
 * A. Osmos - solved
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
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2013//r1b//A-large-practice.in";
    //static final String filepath = System.getProperty("user.dir") + "//src//jam//y2013//r1b//A-small-practice.in";
    //static final String filepath = System.getProperty("user.dir") + "//src//jam//y2013//r1b//A-sample.in";

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));

        int T = Integer.parseInt(in.nextLine()); // The first line of the input gives the number of test cases, T. T test cases follow. 
        for (int t = 1; t <= T; t++) {

            int A = in.nextInt();   // The first line of each test case gives the size of Armin's mote, A
            int N = in.nextInt();   // and the number of other motes, N. 

            ArrayList<Integer> aa = new ArrayList<>(N);
            for (int i = 0; i < N; i++) // // The second line contains the N sizes of the other motes. 
            {
                aa.add(in.nextInt());   // All the mote sizes given will be integers.
            }

            System.out.print("Case #" + t + "   A = " + A + "  N = " + N + "    ");

            // solve
            int Y = 0; // minimum number of operations

            // check for exception A==1
            if (A == 1) // can't eat anything
            {
                Y = N; // cost of removal of everything
            } else {
                Collections.sort(aa);

                /* There are two kinds of operations you can perform, in any order, any number of times: 
                 1. you can add a mote of any positive integer size to the game, or 
                 2. you can remove any one of the existing motes. 
            
                 What is the minimum number of times you can perform those operations in order to 
                 make it possible for Armin's mote to absorb every other mote?
            
                 */
                
                Y = solve(aa, 0, A);

            }

            System.out.println(Y);
            out.println("Case #" + t + ": " + Y);

        }
        in.close();
        out.close();
    }

    public static int solve(ArrayList<Integer> aa, int pos, int A) {
        int Y = 0; // minimum number of operations
        if (pos >= aa.size()) {
            return 0; // out of bounds
        }
        Integer a = aa.get(pos); // item
        if (a < A) {
            Y = solve(aa, pos + 1, A + a); // ate 'a'
        } else {
            // optimizations
            // 1. if the cost of removing this item and remaining ones is lesser than inserting new items
            int AT = A; int YT = 0;
            while (AT <= a)
            {
               AT += AT - 1; YT++; // insert 1 element
            }
                if (YT > aa.size() - pos - 1) {
                Y = aa.size() - pos; // cost of removal of this and remaining items
            } else {
                // solve for 2 strategies: either insert an element or remove an element
                //int Y1 = 1 + solve(aa, pos, A + A - 1); // try inserting an element of a size A-1
                int A1 = A; int Y1 = 0;
                while (A1 <= a)
                {
                    A1 += A1 - 1; Y1++; // insert 1 element
                }
                Y1 += solve(aa, pos + 1, A1 + a); // insert elements of a size A-1; ate element;
                                                        // due to optimization, we know that is going to be 
                                                        // less expensive than removing all other items
                
                int Y2 = 1 + solve(aa, pos + 1, A); // remove current item and continue
                Y = Math.min(Y1, Y2); // least expensive operation
            }
        }

        return Y;
    }

}
