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

public class A {

    static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1a//A-sample.in";
    
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));
                
        int T = in.nextInt();
        int t = 0;
        while (t++ < T) {
          int N = in.nextInt();
          /*
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
                  */
          
          //out.println("Case #" + t + ": " + Y);
      }
       
      in.close();
      out.close();
      
    }
    
       
    
}
