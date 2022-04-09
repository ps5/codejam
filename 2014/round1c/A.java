/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jam.y2014.r1c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author ps
 */
public class A {

    static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1c//A-large-practice.in";

    static int N = 0;

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));

        int T = Integer.parseInt(in.nextLine());
        int t = 0;
        while (t++ < T) {
            String s = in.nextLine();
            String[] ss = s.split("\\/");
            long  P =  Long.parseLong(ss[0]);
            long Q = Long.parseLong(ss[1]);
            System.out.println("Case # " + t + " P=" + P + " Q=" + Q);

            long x2 = 2;
            int gen = 0;
            mainfor:
            for (int g = 1; g <= 40; g++) {
                // deduct 1/x2
                long p = P * x2 -  Q; // - 1*Q
                long q = Q * x2;
                // test if the rest is a valid proportion
                if (isValid(p, q)) {
                    gen = g;
                    System.out.println("Generation: " + g);
                    break mainfor;
                }

                x2 = x2 * 2; // square of 2
            }

            out.println("Case #" + t + ": " + ((gen == 0) ? "impossible" : gen));
            
            
        }

        in.close();
        out.close();

    }

    public static boolean isValid(long p, long q) {
        //System.out.println(" p=" + p + " q=" + q);
        if (p<0 && q>0 || p>0 && q<0) return false;
        if (p==0) return true;
        if (q == 0) 
        {
            System.out.println("error");
        }
        if (p <= q && q % 2 == 0) {
            long g = 2;

            /*
            for (int i = 0; i < 40; i++) {
                if (q == g) {
                    return true;
                }
                g = g * 2;
            }*/

            g  = 2;
            while (q >= g)
            {
                long t = q / g; // must be int
                if (t * g == q)
                {
                    if (p % t == 0)
                        return true;
                }
                g = g*2;
            }
            
            
        }

        return false;

    }
}
