/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

public class C {

    static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1a//C-sample.in";
    
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));
                
        int T = in.nextInt();
        int t = 0;
        while (t++ < T) {
          int N = in.nextInt();
        
          int L = 0; int R = 0; int E = 0;
          for (int i = 0; i < N; i++)
          {
              int x = in.nextInt();
              if (x == i) E++;
              else {if (x < i) L++; else R++;}
          }
          
          System.out.print("Case #" + t + "   E = " + E +  " L = " + L + "  R = " + R + "   ");
          if (E > 1) 
              System.out.println("BAD");
          else
          {
              if (E <= 1 || Math.abs(L - R) * 10 / N > 1)
              System.out.println("GOOD");
          }
          //out.println("Case #" + t + ": " + Y);
      }
       
      in.close();
      out.close();
      
    }
    
       
    
}

