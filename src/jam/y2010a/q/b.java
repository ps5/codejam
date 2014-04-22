/*
Problem

Given a list of space separated words, reverse the order of the words. Each line of text contains L letters and W words. A line will only consist of letters and space characters. There will be exactly one space character between each pair of consecutive words.

Input

The first line of input gives the number of cases, N.
N test cases follow. For each test case there will a line of letters and space characters indicating a list of space separated words. Spaces will not appear at the start or end of a line.

Output

For each test case, output one line containing "Case #x: " followed by the list of words in reverse order.

Limits

Small dataset

N = 5
1 ≤ L ≤ 25

Large dataset

N = 100
1 ≤ L ≤ 1000


 */

package jam.y2010a.q;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ps
 */
public class b {
  
    static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2010a//q//B-large-practice.in";
    
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));
                        
        int T = Integer.parseInt(in.nextLine());
        int t = 0;
        while (t++ < T) {
          String st = in.nextLine();
          String stt[] = st.split(" ");
          int i=stt.length;
          out.print("Case #" + t + ": " + stt[--i]);
          while (i>0)
          {
              out.print(" " + stt[--i]);
          }
          out.println();
        }
        
        in.close();
        out.close();
    }
          
}
