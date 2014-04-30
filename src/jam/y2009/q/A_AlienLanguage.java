/*
 Problem

 After years of study, scientists at Google Labs have discovered an alien language transmitted from a faraway planet. The alien language is very unique in that every word consists of exactly L lowercase letters. Also, there are exactly D words in this language.

 Once the dictionary of all the words in the alien language was built, the next breakthrough was to discover that the aliens have been transmitting messages to Earth for the past decade. Unfortunately, these signals are weakened due to the distance between our two planets and some of the words may be misinterpreted. In order to help them decipher these messages, the scientists have asked you to devise an algorithm that will determine the number of possible interpretations for a given pattern.

 A pattern consists of exactly L tokens. Each token is either a single lowercase letter (the scientists are very sure that this is the letter) or a group of unique lowercase letters surrounded by parenthesis ( and ). For example: (ab)d(dc) means the first letter is either a or b, the second letter is definitely d and the last letter is either d or c. Therefore, the pattern (ab)d(dc) can stand for either one of these 4 possibilities: add, adc, bdd, bdc.

 Input

 The first line of input contains 3 integers, L, D and N separated by a space. D lines follow, each containing one word of length L. These are the words that are known to exist in the alien language. N test cases then follow, each on its own line and each consisting of a pattern as described above. You may assume that all known words provided are unique.

 Output

 For each test case, output

 Case #X: K
 where X is the test case number, starting from 1, and K indicates how many words in the alien language match the pattern.
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
public class A_AlienLanguage {

    public void main(String testName) {

        InputStream fis;
        BufferedReader br;

        try {
            //fis = new FileInputStream("c:\\data\\codejam\\C-small-practice.in");
            //fis = new FileInputStream("c:\\data\\codejam\\C-large-practice.in");
            fis = new FileInputStream(testName);
            br = new BufferedReader(new InputStreamReader(fis)); //, Charset.forName("UTF-8")));


            String params[] = br.readLine().split(" ");
            String line = "";

            int L = Integer.parseInt(params[0]); // length
            int D = Integer.parseInt(params[1]); // words
            int N = Integer.parseInt(params[2]); // number of cases
            int cc = 0;

            // read words
            String words[] = new String[D];
            int i = 0;
            while ((i < D) && ((line = br.readLine()) != null)) {

                words[i] = line;
                //System.out.println("Word " + i + ": " + line);
                i++;
            }

            // read patterns (cases)
            String cases[] = new String[N];
            i = 0;
            while ((i < N) && ((line = br.readLine()) != null)) {

                cases[i] = line;
                //System.out.println("Case: " + i + ": " + line);
                i++;
            }



            // solve it            
            for (cc = 0; cc < cases.length; cc++) {

                System.out.print("Case #" + (cc + 1) + ": ");
                int m = 0; // # of matches
                // iterate through the words and compare with the patterns

                String x = cases[cc];  //System.out.println(x);
                for (int j = 0; j < words.length; j++) {

                    // compare a case with the word
                    String w = words[j];
                    int p = 0;
                    boolean charMatches = false;
                    for (i = 0; i < w.length(); i++) 
                    {   // compare char by char
                        charMatches = false;    // reset
                        char c = w.charAt(i);
                        if (x.charAt(p) == ')') { p++; }
                        if (x.charAt(p) == c) {
                            charMatches = true;
                            p++;
                        } else if (x.charAt(p) == '(') { // check the pattern
                            while (p < x.length() && x.charAt(p) != ')' && !charMatches) {
                                if (x.charAt(p) == c) {
                                    charMatches = true;   // match
                                    //break;
                                }
                                p++;
                            }
                            while (x.charAt(p) != ')') { p++; }
                        }
                        

                        if (!charMatches) {
                            break; // stop after a char didn't match the pattern
                         }
                    }

                    if (charMatches) { // word matches
                        m++;
                        //System.out.println(w);
                    }
                }   // end words

                System.out.println(m);

            }   // end cases

            br.close();
            fis.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
