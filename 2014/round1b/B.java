/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jam.y2014.r1b;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author ps
 */
public class B {
 
     static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1b//B-sample.in";
    //static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1b//B-small-practice.in";
    //static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1b//B-large-practice.in";

    static int N = 0;
    
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));

        int T = in.nextInt();
        int t = 0;
        //while (t++ < T) 
        {
            int A = in.nextInt() -1;
            int B = in.nextInt() -1;
            int K = in.nextInt() -1;
            
            System.out.print("Case #" + t + "  A = " + A + " B = " + B + " K = " + K + "  Solution: ");
            System.out.println("Case #" + t + "  bits in A = " + (log2(A)+1) + "  bits: " + Integer.toBinaryString(A));
            System.out.println("Case #" + t + "  bits in B = " + (log2(B)+1) + "  bits: " + Integer.toBinaryString(B));
            System.out.println("Case #" + t + "  bits in K = " + (log2(K)+1) + "  bits: " + Integer.toBinaryString(K));
            
            /*
            combinations:
            0,0
            0 * (B) 0,1 0,2 0,3
            (A) * 0  1,0 2,0
            2 * (min(A,K) * min(B,K)) - 1   1,1   
            K * B'  1,2 1,3   (count of bits in B above K and count of bits below B)
            A' * K    2,1  A': count of bits in A above K   * K 
            count of bits in B below K 
            
            */
            
            int P = 1 + B + A;
            P += 2 * (Math.min(A,K) * Math.min(B,K)) - 1;
            
            
            int A1 = Math.min(A-1, (K-1));
            int B1 = B; //log2(Math.min(A1, B));
            int P1 = (A1+1) * (B1+1);
            
            System.out.println(A1 +" " + B1 + " " + P1);
            
            B1 = Math.min(B-1, (K-1));
            A1 = A;
            int P2 = (A1+1) * (B1+1);
            System.out.println(A1 +" " + B1 + " " + P2);                        
            
            P1 += P2;
            System.out.println(P1);
            System.out.println();
        }
        
       
            in.close();
        out.close();
    }
    
    public static int log2(int n){
    if(n <= 0) throw new IllegalArgumentException();
    return 31 - Integer.numberOfLeadingZeros(n);
}
}
