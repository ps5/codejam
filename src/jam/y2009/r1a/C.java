/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jam.y2009.r1a;

import java.util.*;
/**
 *
 * @author shiryap
 */
public class C {
    
    public static void ProblemC() {
        
        int[][] C = {{3, 0}, {6, 0}, {14,0}};
        int P = 20;
        int Q = 3;
        
        System.out.println(C.length);
        //int [] C = new int[Q.length];
        
        for (int i=0; i<Q; i++) {
            C[i][1] = ((i==0) ? (C[i][0] - 1) : (C[i][0] - C[i-1][0] - 1)) + ((i==Q-1) ? (P - C[i][0]) : (C[i+1][0] - C[i][0] - 1));
            System.out.println(i+1 + ": #" + C[i][0] + " $" + C[i][1]);
        }
        
        //Arrays.sort(Q[]);
        for (int i=0; i<Q; i++) {
            System.out.println(i+1 + ": #" + C[i][0] + " $" + C[i][1]);
        }        
    }
    
}
