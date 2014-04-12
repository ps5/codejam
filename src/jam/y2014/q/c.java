/*
 Qualification Round 2014
 C. Minesweeper Master
 */
package jam.y2014.q;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author shiryap
 */
public class c {

    static Scanner in;
    static PrintStream out;
    //static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//q//C-large.in";
    //static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//q//C-small-attempt2.in";
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//q//C-test-5x5.in";

    static int rectX = 0;
    static int rectY = 0;

    static int rectX1 = 0;
    static int rectY1 = 0;
    static int rectX2 = 0;
    static int rectY2 = 0;
    static int rectX3 = 0;
    static int rectY3 = 0;

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));

        int T = Integer.parseInt(in.nextLine()); // The first line of the input gives the number of test cases, T. T test cases follow. 
        for (int t = 1; t <= T; t++) {

            int R = in.nextInt();
            int C = in.nextInt();
            int M = in.nextInt();

            System.out.println("Case #" + t + ": " + R + " " + C + " " + M);

            if (C * R <= M) {
                throw new RuntimeException("Limit violation: 0 ≤ " + M + " < " + R + " * " + C);
            }

            out.println("Case #" + t + ":");
            if (testOneClick(R, C, M) == true) {
                display(R, C, M);
            } else {
                System.out.println("Impossible");
                out.println("Impossible");
            }
        }

    }

    public static boolean testOneClick(int R, int C, int M) {

        rectX = 0;
        rectY = 0; // reset
                rectX1 = 0;
        rectY1 = 0;
        rectX2 = 0;
        rectY2 = 0;
        rectX3 = 0;
        rectY3 = 0;
        
        int S = C * R - M; // count of spaces not occupied by mines

        // if 1 free space only then win
        if (S == 1) {
            rectX1 = 1;
            rectY1 = 1;
            return true;
        }

        // if 1 row or 1 column then 1 click will win
        if (S > 0 && (C == 1 || R == 1)) {
            rectX1 = C;
            rectY1 = R;
            if (C == 1) {
                rectY1 = S;
            } else {
                rectX1 = S;
            }
            return true;
        }
        /* // a rectangle/square subcase: if even number and S > 2 then win
         if (S % 2 == 0 && S != 2) 
         {
         rectX = .. ;
         return true;
         }*/

        // a simple rectangle/square general case: find 2 integer divisors x, y where (x <= R && y <= C) || (..)
        if (testRectangle3(S, R, C)) {
            return true;
        }

        /* superseded by testRectangle3
        // test advanced rectangle/stakan subcase where it's limited by R or C (stakan)
        // as long as we get at least 2 rows or 2 columns and it's not to narrow (>2 cells wide) 
        // and it's all squares we win
        // 1. solve for y = R - fill left to the right:
        if (S / R >= 2 && R > 2) {
            if (S - (S / R) * R != 1) { // can fit a square
                rectX = S / R;
                rectY = R;
                return true;
            }
        }
        // 2. solve for x = C  - fill up to bottom:
        if (S / C >= 2 && C > 2) {
            if (S - (S / C) * C != 1) {
                rectX = C;
                rectY = S / C;
                return true;
            }
        }
*/
        

        /* not one click solution?
         // a rectange/square + 1 subcase 
         if (testRectangle(S - 1, R - 1, C - 1)) {
         return true;
         }
         */
        return false;
    }

    public static boolean testRectangle3(int S, int R, int C) {

        for (int ir = 2; ir <= R; ir++) {
            for (int ic = 2; ic <= C; ic++) {
                int testS = ir * ic;
                if (testS == S) // can fit in one rectangle
                {
                    rectX1 = ic;
                    rectY1 = ir;
                    return true;
                } else if (testS > S) {
                    break; // skip iteration
                } else // still fits; try a second rectangle
                {
                    for (int ir2 = ir + 1; ir2 <= R; ir2++) {
                        for (int ic2 = 2; ic2 < ic; ic2++) {
                            int testS2 = (ir2 - ir) * ic2;
                            if (testS + testS2 == S) // 2 rectangles fit
                            {
                                rectX1 = ic;
                                rectY1 = ir;
                                rectX2 = ic2;
                                rectY2 = ir2;
                                return true;
                            } else if (testS + testS2 > S) {
                                break; // skip iteration
                            } else // still has space; try 3rd rectangle
                            {
                                for (int ir3 = ir + 1; ir3 < ir2; ir3++) {
                                    for (int ic3 = ic2 + 1; ic3 < ic; ic3++) {
                                        int testS3 = (ic3 - ic2) * (ir3 - ir);
                                        if (testS + testS2 + testS3 == S) // 3 rectangles fit
                                        {
                                            rectX1 = ic;
                                            rectY1 = ir;
                                            rectX2 = ic2;
                                            rectY2 = ir2;
                                            rectX3 = ic3;
                                            rectY3 = ir3;
                                            return true;
                                        } else if (testS + testS2 + testS3 > S) {
                                            break; // out of free space
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    /*
    public static boolean testRectangle(int S, int R, int C) {

        int x = S / 2;
        int y = 0;
        while (x > 1) // side is >= 2 cells at least
        {
            y = S / x;
            if ((x * y == S) // we have a rectangle
                    && (x > 0 && ((x <= R && y <= C) || (x <= C && y <= R)))) // and it fits the RC boundaries
            {
                if ((x <= R && y <= C)) {
                    rectX = y;
                    rectY = x;
                } else {
                    rectX = x;
                    rectY = y;
                }
                return true;
            } // win
            else {
                x--;
            }

        }
        return false;
    }

    public static void display(int R, int C, int M) {

        int S = C * R - M; // count of spaces not occupied by mines\
        int testM = M;

        if (rectX == 0 || rectY == 0) {
            throw new RuntimeException("Program error: rectX = " + rectX + "; rectY = " + rectY);
        }

        // draw a rectangle
        // test a special case of stakan
        // draw stakan: a rectangle plus extra elements to the side
        if (rectX == C) { // fill up to bottom
            System.out.println("Stakan: fill down");
            for (int ir = 1; ir <= R; ir++) {
                String row = "";
                for (int ic = 1; ic <= C; ic++) {
                    if (ir == 1 && ic == 1) {
                        row += "c";
                    } // else if (ir <= rectY && ic <= rectX) { row += ".";
                    else if (S - C * (ir - 1) - ic >= 0) {
                        row += ".";
                    } else {
                        {
                            row += "*";
                            testM--;
                        }
                    }

                }
                System.out.println(row);
                out.println(row);
            }
        } else if (rectY == R) {// fill left to right
            System.out.println("Stakan: fill left to right");
            for (int ir = 1; ir <= R; ir++) {
                String row = "";
                for (int ic = 1; ic <= C; ic++) {
                    if (ir == 1 && ic == 1) {
                        row += "c";
                    } // else if (ir <= rectY && ic <= rectX) { row += ".";
                    else if (S - R * (ic - 1) - ir >= 0) {
                        row += ".";
                    } else {
                        {
                            row += "*";
                            testM--;
                        }
                    }

                }
                System.out.println(row);
                out.println(row);
            }

        } else {
            // draw a simple rectangle
            System.out.println("Simple rectangle");

            for (int ir = 1; ir <= R; ir++) {
                String row = "";
                for (int ic = 1; ic <= C; ic++) {
                    if (ir == 1 && ic == 1) {
                        row += "c";
                    } else if (ir <= rectY && ic <= rectX) {
                        row += ".";
                    } else if ((rectX * rectY == S - 1) // draw a special case of a rectangle xy+1
                            && (ir == rectY + 1 && ic == rectX + 1)) {
                        row += ".";
                    } else {
                        {
                            row += "*";
                            testM--;
                        }
                    }
                }
                System.out.println(row);
                out.println(row);

            }

        }

        // assert(testM == 0); // make sure all mines have been displayed 
        if (testM != 0) {
            throw new RuntimeException("Display error: not all mines displayed");
        }
    }
*/
    
    
    public static void display(int R, int C, int M) {

        int S = C * R - M; // count of spaces not occupied by mines\
        int testM = M;

        if (rectX1 == 0 || rectY1 == 0) {
            throw new RuntimeException("Program error: rectX = " + rectX1 + "; rectY = " + rectY1);
        }
        
        for (int ir = 1; ir <= R; ir++) {
                String row = "";
                for (int ic = 1; ic <= C; ic++) {
                    if (ir == 1 && ic == 1) {
                        row += "c";
                    } // else if (ir <= rectY && ic <= rectX) { row += ".";
                    else 
                        if ((ir <= rectY1 && ic <= rectX1)  // first rectangle
                        
                                )        
                        {
                        row += ".";
                    } else if (ir > rectY1 && ir <= rectY2 && ic <= rectX2 ) // second rectangle
                        row += ".";
                    else if (ir > rectY1 && ir <= rectY3  && ic > rectX2 && ic <= rectX3) // 3rd triangle
                        row += ".";
                        else {
                        {
                            row += "*";
                            testM--;
                        }
                    }

                }
                System.out.println(row);
                out.println(row);
            }

        // assert(testM == 0); // make sure all mines have been displayed 
        if (testM != 0) {
            throw new RuntimeException("Display error: not all mines are displayed: " + R + " " + C + " " + M);
        }
    }
}
