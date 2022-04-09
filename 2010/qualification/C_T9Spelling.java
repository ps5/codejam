/*
Problem

The Latin alphabet contains 26 characters and telephones only have ten digits on the keypad. We would like to make it easier to write a message to your friend using a sequence of keypresses to indicate the desired characters. The letters are mapped onto the digits as shown below. To insert the character B for instance, the program would press 22. In order to insert two characters in sequence from the same key, the user must pause before pressing the key a second time. The space character ' ' should be printed to indicate a pause. For example, 2 2 indicates AA whereas 22 indicates B.
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
public class C_T9Spelling {
    public void main() {

        InputStream fis;
        BufferedReader br;

        try {
            //fis = new FileInputStream("c:\\data\\codejam\\C-small-practice.in");
            fis = new FileInputStream("c:\\data\\codejam\\C-large-practice.in");
            //fis = new FileInputStream("c:\\data\\codejam\\C-test.in");
            br = new BufferedReader(new InputStreamReader(fis)); //, Charset.forName("UTF-8")));


            String line = br.readLine(); int nc = Integer.parseInt(line); // number of cases
            int cc = 0;

            while ((line = br.readLine()) != null) {
                cc++;
                System.out.print("Case #" + cc + ": ");

                String pd = " ";
                for (int i = 0; i<line.length(); i++) {
                 
                    String dd = "";
                    char c = line.charAt(i);
                    switch (c) {
                     
                        case ' ':  dd = "0"; break;
                        case 'a':  dd = "2"; break;
                        case 'b':  dd = "22"; break;
                        case 'c':  dd = "222"; break;
                        case 'd':  dd = "3"; break;
                        case 'e':  dd = "33"; break;
                        case 'f':  dd = "333"; break;
                        case 'g':  dd = "4"; break;
                        case 'h':  dd = "44"; break;
                        case 'i':  dd = "444"; break;
                        case 'j':  dd = "5"; break;
                        case 'k':  dd = "55"; break;
                        case 'l':  dd = "555"; break;
                        case 'm':  dd = "6"; break;
                        case 'n':  dd = "66"; break;
                        case 'o':  dd = "666"; break;
                        case 'p':  dd = "7"; break;
                        case 'q':  dd = "77"; break;
                        case 'r':  dd = "777"; break;
                        case 's':  dd = "7777"; break;
                        case 't':  dd = "8"; break;
                        case 'u':  dd = "88"; break;
                        case 'v':  dd = "888"; break;
                        case 'w':  dd = "9"; break;
                        case 'x':  dd = "99"; break;
                        case 'y':  dd = "999"; break;
                        case 'z':  dd = "9999"; break;
                    }                        
                    
                    if (dd.charAt(0) == pd.charAt(pd.length() - 1)) {   // same digit
                        dd = " " + dd; // add space
                    }
                    
                    System.out.print(dd);
                    pd = dd;
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
