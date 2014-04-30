/*
 * Problem

 You receive a credit C at a local store and would like to buy two items. You first walk through the store and create a list L of all available items. From this list you would like to buy two items that add up to the entire value of the credit. The solution you provide will consist of the two integers indicating the positions of the items in your list (smaller number first).

 Input


 Output

 For each test case, output one line containing "Case #x: " followed by the indices of the two items whose price adds up to the store credit. The lower index should be output first.

 Limits

 5 ≤ C ≤ 1000
 1 ≤ P ≤ 1000

 Small dataset

 N = 10
 3 ≤ I ≤ 100

 Large dataset

 N = 50
 3 ≤ I ≤ 2000

 Sample


 Input 

 Output 
 3
 100
 3
 5 75 25
 200
 7
 150 24 79 50 88 345 3
 8
 8
 2 1 9 4 4 56 90 3

 */
package codejam;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 *
 * @author Pavel.Shiryaev
 */
public class A_StoreCredit {

    public void main() {

        InputStream fis;
        BufferedReader br;

        try {
            fis = new FileInputStream("c:\\data\\codejam\\A-small-practice.in");
            //fis = new FileInputStream("c:\\data\\codejam\\A-large-practice.in");
            //fis = new FileInputStream("c:\\data\\codejam\\test.in");
            br = new BufferedReader(new InputStreamReader(fis)); //, Charset.forName("UTF-8")));



            String line = br.readLine();
            int nc = Integer.parseInt(line); // number of cases
            int cc = 0;

            while ((line = br.readLine()) != null) {
                cc++;
                System.out.print("Case #" + cc + ": ");

                //line = br.readLine();
                int c = Integer.parseInt(line); // credit
                line = br.readLine();
                int n = Integer.parseInt(line); // number of items
                line = br.readLine(); // items/prices
                String prices[] = line.split(" ");
                int q = prices.length; // number of items
                if (!(q == n)) {
                    System.out.println("Error # of items: " + q + " <> " + n);
                }

                int p[] = new int[n];
                for (int ii = 0; ii < prices.length; ii++) {
                    p[ii] = Integer.parseInt(prices[ii]);
                }
                //Arrays.sort(p);

                for (int i = n-1; i >= 0; i--) {
                    if (p[i] < c) {
                        for (int j = i - 1; j >= 0; j--) {
                            if (p[i] + p[j] == c) {
                                System.out.print((j+1) + " " + (i+1));
                                //System.out.print("     " + p[j] + " " + p[i] + " " + c);
                                i = -1;
                                break; // stop for loop
                            }
                        }
                    }
                }

                System.out.println();


            }






            br.close();
            fis.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}