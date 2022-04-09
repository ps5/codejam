/*
 Problem

 Given a list of space separated words, reverse the order of the words. Each line of text contains L letters and W words. A line will only consist of letters and space characters. There will be exactly one space character between each pair of consecutive words.

 Input

 The first line of input gives the number of cases, N.
 N test cases follow. For each test case there will a line of letters and space characters indicating a list of space separated words. Spaces will not appear at the start or end of a line.

 Output

 For each test case, output one line containing "Case #x: " followed by the list of words in reverse order.

 Limits

 Small dataset

 N = 5
 1 ≤ L ≤ 25

 Large dataset

 N = 100
 1 ≤ L ≤ 1000

 Sample


 Input 

 Output 
 3
 this is a test
 foobar
 all your base
 Case #1: test a is this
 Case #2: foobar
 Ca
 */
package codejam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Pavel.Shiryaev
 */
public class B_ReverseWords {

    public void main() {

        InputStream fis;
        BufferedReader br;

        try {
            //fis = new FileInputStream("c:\\data\\codejam\\B-small-practice.in");
            fis = new FileInputStream("c:\\data\\codejam\\B-large-practice.in");
            //fis = new FileInputStream("c:\\data\\codejam\\test.in");
            br = new BufferedReader(new InputStreamReader(fis)); //, Charset.forName("UTF-8")));


            String line = br.readLine(); int nc = Integer.parseInt(line); // number of cases
            int cc = 0;

            while ((line = br.readLine()) != null) {
                cc++;
                System.out.print("Case #" + cc + ": ");

                String words[] = line.split(" ");
                for (int i = words.length -1; i >=0; i--) {
                    System.out.print(words[i] + " ");
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