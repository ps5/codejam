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

import static jam.y2014.r1a.C.in;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B {

    static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1a//B-sample.in";
    
    public static void main(String[] args) throws FileNotFoundException
    {
        
     
        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));
                
        
        for (int test = 1; test < 10; test++) {
        int a[] = new int[100];
        for (int i = 0; i< 100; i++)
        
            a[i] = i;
        
            for (int i = 0; i< 100; i++)
            {
                //int p = i + (int) (Math.random() * (100.0-i));
                int p = (int) (Math.random() * 100.0);
                
                int tmp = a[p]; a[p] = a[i]; a[i] = tmp;
            }
        
        
        //System.out.println(Arrays.toString(a));
        
        int L = 0; int R = 0; int E = 0; int X2 = 0;
          for (int i = 0; i < 100; i++)
          {
              int x = a[i];
              if (x == i) E++;
              else {if (x < i) L++; else R++;}
              
              X2 += (x - i) * (x-i);
          }
          int X = (L - R);
          System.out.println("E = " + E +  " L = " + L + "  R = " + R + "   " + X + "    " + X2);
        
        }
      
       
      in.close();
      out.close();
      
    }
    
       
    
}
