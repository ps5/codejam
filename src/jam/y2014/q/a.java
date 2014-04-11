/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jam.y2014.q;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class a {

    static Scanner in;
    static PrintStream out;
    static final String filepath = "C:\\Users\\shiryap\\Documents\\NetBeansProjects\\jam\\src\\jam\\y2008\\r1a\\";
    
    public static void main(String[] args) throws FileNotFoundException
    {
        in = new Scanner(new File(filepath + "A-large-practice.in"));
        out = new PrintStream(new File(filepath + "A-large.out"));
                
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
