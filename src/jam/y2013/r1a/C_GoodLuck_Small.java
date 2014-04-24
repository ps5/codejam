/* Practice
 */
package jam.y2013.r1a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Collections;
import java.util.TreeSet;

/**
 *
 * @author shiryap
 */
public class C_GoodLuck_Small {

    static Scanner in;
    static PrintStream out;
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2013//r1a//C-small-practice-1.in";

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));

        int T = in.nextInt(); // 1
        int R = in.nextInt(); // 100
        int N = in.nextInt(); // 3
        int M = in.nextInt(); // 5
        int K = in.nextInt(); // 7

        int t = 0;
        while (t++ < T) {

            out.println("Case #" + t + ": ");

            int r = 0;
            while (r++ < R) {

                int[] kk = new int[K];

                for (int i = 0; i < K; i++) {
                    kk[i] = in.nextInt();
                }

                String ans = ""; // 
                for (int A1 = 2; A1 <= M; A1++) {
                   
                    if (ans.length() > 0) break;

                    for (int A2 = 2; A2 <= M; A2++) {
                        if (ans.length() > 0) break;
                        
                        for (int A3 = 2; A3 <= M; A3++) {
                            c:
                            
                            ans = ""; //
                            for (int k = 0; k < K; k++) {
                                if (kk[k] != 1) {
                                    if (A1 * A2 * A3 == kk[k] || A1 * A2 == kk[k] || A1 * A3 == kk[k] || A2 * A3 == kk[k] || A1 == kk[k] || A2 == kk[k] || A3 == kk[k]) {
                                        ans = A1 + "" + A2 + "" + A3;
                                    } else {
                                        ans = "";
                                        break;
                                    } // no answer
                                }
                            
                        }
                        if (ans.length() > 0) // found
                        
                            break;
                        
                    }
                }
            }

            if (ans.length() == 0) {
                ans = "222";  // no answer
            }
            // print numbers
            for (int k=0; k < kk.length; k++)
            {System.out.print(kk[k] + " ");} System.out.println(": " + ans);
            out.println(ans);
        }
    }

    in.close ();

    out.close ();

}
}
