package jam.y2013.r1a;
import java.io.*;
import java.util.*;
/**
 *
 * @author Pavel.Shiryaev
 */
public class A_BullsEye {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = "c:\\Documents and Settings\\pavel.shiryaev\\My Documents\\NetBeansProjects\\RoundA_A_BullsEye\\src\\rounda_a_bullseye\\A-small-attempt0.in";

        InputStream fis;
        OutputStream fos;
        BufferedReader br;
        BufferedWriter bw;

        String output = "";

        try {
            fis = new FileInputStream(fileName);
            fos = new FileOutputStream(fileName.concat(".out"));

            br = new BufferedReader(new InputStreamReader(fis)); //, Charset.forName("UTF-8")));
            bw = new BufferedWriter(new OutputStreamWriter(fos)); //, Charset.forName("UTF-8")));

            String line = br.readLine();
            int nc = Integer.parseInt(line); // The first line of the input gives the number of test cases, T. T test cases follow. 

            // read cases
            for (int cc = 1; cc <= nc; cc++) {

                System.out.print("Case #" + cc + " out of " + nc + ": ");

                String[] rt = br.readLine().split(" ");
                
                long r = Long.parseLong(rt[0]); //Maria draws the first black ring around a white circle of radius r cm. 
                long t = Long.parseLong(rt[1]); // Maria starts with t millilitres of black paint, which she will use to draw rings of thickness 1cm (one centimetre)

                long count = (long) -1;
                
                while (t >= 0)
                {
                    count++;
                    //t -= (r + 1) * (r+1) - r*r; // (r + 1) * (r+1) - r*r = r^2 + 2r + 1 - r^2 = 2r + 1
                    t -= r + r + 1;
                    /*t -= r;
                    t -=r;
                    t -=1; 
                    // 1. pi * 2^2 - pi * 1^2; z = 2^2 - 1^2 = 4 - 1 = 3
                    // 2. pi * 4^2 - pi * 3^2; z = 4^2 - 3^2 = 16 - 9 = 7
                    r++; r++;
                    * */
                                        
                    r = r + 2;
                    
                    // t = t - (2r + 1) - (2r + 4 + 1) - (2r + 8 + 1)
                }
                
                
                System.out.println(count);

                bw.write("Case #" + cc + ": " + count);
                bw.newLine();


                // line = br.readLine(); // Each test case is followed by an empty line.

            }   // end for cc; test case


            br.close();
            fis.close();
            bw.close();
            fos.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


    }
}
