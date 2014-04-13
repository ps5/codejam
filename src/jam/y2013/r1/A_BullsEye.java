package jam.y2013.r1;

import java.io.*;
import java.util.*;

/**
 *
 * @author Pavel.Shiryaev
 */
public class A_BullsEye {

    //static final String filepath = System.getProperty("user.dir") + "//src//jam//y2013//r1//A-small-practice.in";
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2013//r1//A-large-practice.in";

    public static void main(String[] args) throws FileNotFoundException, IOException {

        InputStream fis;
        OutputStream fos;
        BufferedReader br;
        BufferedWriter bw;

        String output = "";

        fis = new FileInputStream(filepath);
        fos = new FileOutputStream(filepath.concat(".out"));

        br = new BufferedReader(new InputStreamReader(fis)); //, Charset.forName("UTF-8")));
        bw = new BufferedWriter(new OutputStreamWriter(fos)); //, Charset.forName("UTF-8")));

        String line = br.readLine();
        int nc = Integer.parseInt(line); // The first line of the input gives the number of test cases, T. T test cases follow. 
        Map results = new HashMap<Long, Result>(); // r, t;count

        // read cases
        for (int cc = 1; cc <= nc; cc++) {

            System.out.print("Case #" + cc + " out of " + nc + ": ");

            String[] rt = br.readLine().split(" ");

            long r = Long.parseLong(rt[0]); //Maria draws the first black ring around a white circle of radius r cm. 
            long t = Long.parseLong(rt[1]); // Maria starts with t millilitres of black paint, which she will use to draw rings of thickness 1cm (one centimetre)

            long radius = r;
            long count = (long) -1;
            boolean saveResult = true;

            Result result = (Result) results.get(radius);

            if (result == null) { // new case
                result = new Result(radius);
                result.t = t; // original quantity
            } else {
                if (result.t < t) // lesser quantity - will play
                {
                    count = result.count - 1;
                    t = result.tt;
                    r = result.rr;
                    saveResult = false;
                }

            }
            while (t >= 0) {
                count++;
                t -= r + r + 1;
                r = r + 2;
            }

            System.out.println(count);

            if (saveResult) {
                result.rr = r - 2;
                result.tt = t + (r - 2) + (r - 2) + 1; // paint remaining
                result.count = count;
                results.put(radius, result);
            }

            bw.write("Case #" + cc + ": " + count);
            bw.newLine();

            // line = br.readLine(); // Each test case is followed by an empty line.
        }   // end for cc; test case

        br.close();
        fis.close();
        bw.close();
        fos.close();

    }
}

class Result {

    public long count = 0;
    public long t = 0;
    public long tt = 0;
    public long r = 0;
    public long rr = 0;

    Result(Long radius) {
        r = radius;

    }

}
