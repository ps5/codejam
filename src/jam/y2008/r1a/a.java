/*
Problem

You are given two vectors v1=(x1,x2,...,xn) and v2=(y1,y2,...,yn). The scalar product of these vectors is a single number, calculated as x1y1+x2y2+...+xnyn.

Suppose you are allowed to permute the coordinates of each vector as you wish. Choose two permutations such that the scalar product of your two new vectors is the smallest possible, and output that minimum scalar product.

Input

The first line of the input file contains integer number T - the number of test cases. For each test case, the first line contains integer number n. The next two lines contain n integers each, giving the coordinates of v1 and v2 respectively.
Output

For each test case, output a line

Case #X: Y
where X is the test case number, starting from 1, and Y is the minimum scalar product of all permutations of the two given vectors.
 */

/**
 *
 * @author shiryap
 */
package jam.y2008.r1a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class a {

    static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2008//r1a//A-large-practice.in";
    
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));
                
        int T = in.nextInt();
        int t = 0;
        while (t++ < T) {
          int N = in.nextInt();
          ArrayList av1 = new ArrayList<Long>(N);
          readVector(av1, N);
          Collections.sort(av1);
          
          ArrayList av2 = new ArrayList<Long>(N);
          readVector(av2, N);
          Collections.sort(av2, Collections.reverseOrder());
          
          long Y = 0;
          for (int i = 0; i< N; i++)
          {
              Y += (Long)av1.get(i) * (Long)av2.get(i);
          }
          out.println("Case #" + t + ": " + Y);
      }
       
      in.close();
        
    }
    
    public static void readVector(ArrayList<Long> ai, int N)
    {
        for (int i = 0; i< N; i++)
          {
              ai.add(in.nextLong());
          }
    }
    
    
}
