/*
 * Google Code Jam 2014
 * Round 1A
 */
package jam.y2014.r1a;

/**
 *
 * @author shiryap
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B {

    static Scanner in;
    static PrintStream out;
    //static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1a//B-sample.in";
    //static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1a//B-small-practice.in";
    static final String filepath = System.getProperty("user.dir") + "//src//jam//y2014//r1a//B-large-practice.in";

    static int N = 0;
    
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println(filepath);
        in = new Scanner(new File(filepath));
        out = new PrintStream(new File(filepath + ".out"));

        int T = in.nextInt();
        int t = 0;
        while (t++ < T) {
            N = in.nextInt();
            in.nextLine();
            System.out.print("Case #" + t + "  N = " + N + "    Solution: ");

            // read array
            ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>(N);
            for (int n = 0; n < N + 1; n++) {
                a.add(new ArrayList<Integer>());
            }
            for (int n = 0; n < N - 1; n++) {
                int N1 = in.nextInt();
                int N2 = in.nextInt();

                ArrayList AN1 = a.get(N1);
                AN1.add(N2);
                ArrayList AN2 = a.get(N2);
                AN2.add(N1);
            }

            // iterate thru array, assign selected node as root
            int minSol = N;
            int rootNode = -1;
            for (int n = 1; n <= N; n++) {
                // use recursion to count number of nodes with 1 edge
                int result = solve(a, n, 0);
                if (result < minSol) {
                    rootNode = n;
                    minSol = result;
                }
            }

            /*for (int n = 0; n < a.size(); n++) {
             ArrayList A = a.get(n);
             System.out.println(n + ": " + A.toString());
             }*/
            System.out.println("Root node: " + rootNode + "  best solution: " + minSol);
            out.println("Case #" + t + ": " + minSol);

        }

        in.close();
        out.close();

    }

    public static int solve(ArrayList<ArrayList<Integer>> a, int currentNode, int parentNode) {

        // get copy of a node
        ArrayList<Integer> Node = new ArrayList<Integer>();
        for (Integer n : a.get(currentNode))
        {
            if (n != parentNode) Node.add(n);
        }
        
        int x = Node.size();

        int count = 0;
        if (x == 0) // that's our parent; no children
        {
            return 0;
        } else if (x == 1) {
            // bad node - need to remove it and all of its descendants
            for (Integer n : Node) {
                if (n != parentNode) {
                    count += 1 + countChildren(a, n, currentNode);
                }

            }

        } else if (x == 2) // ideal; have two children & parent
        {
            for (Integer n : Node) {
                if (n != parentNode) {
                    count += 0 + solve(a, n, currentNode); // test children nodes
                }

            }

        } else if (x >= 3) // 3 or more children
        {
            int minCost = 100000;
            // find the two most expensive branches to retain
            int costToKeep[] = new int[N+1];
            int costToRemove[] = new int[N+1];
            for (Integer n1 : Node) { 
                costToKeep[n1] = solve(a, n1, currentNode);
                costToRemove[n1] = 1 + countChildren(a, n1, currentNode);
            }
            
            for (Integer n1 : Node) {
                int costToKeep1 = costToKeep[n1];
                for (Integer n2 : Node) {
                    if (n2 != n1) {
                    int costToKeep2 = costToKeep[n2];
                    int costToRemoveRest = 0;
                    for (Integer n3 : Node) {
                        if (n3 != n2 && n3 != n1) {
                            costToRemoveRest += costToRemove[n3];
                        }
                    }
                    int totalCost = costToKeep1 + costToKeep2 + costToRemoveRest;
                    minCost = (totalCost < minCost) ? totalCost : minCost;
                 }
                }
            }
                    
            
            /*for (Integer n1 : Node) {
                int costToKeep1 = solve(a, n1, currentNode);
                for (Integer n2 : Node) {
                    if (n2 != n1) {
                    int costToKeep2 = solve(a, n2, currentNode);
                    int costToRemoveRest = 0;
                    for (Integer n3 : Node) {
                        if (n3 != n2 && n3 != n1) {
                            costToRemoveRest += 1 + countChildren(a, n3, currentNode);
                        }
                    }
                    int totalCost = costToKeep1 + costToKeep2 + costToRemoveRest;
                    minCost = (totalCost < minCost) ? totalCost : minCost;
                 }
                }
            }*/

            count = minCost;
        } else {
            System.out.println("Node: " + currentNode + "   " + Node.toString());
            throw new RuntimeException("Wrong count of edges: " + x + "; parent " + parentNode);
        }

        return count;
    }

    public static int countChildren(ArrayList<ArrayList<Integer>> a, int currentNode, int parentNode) {
        ArrayList<Integer> A = a.get(currentNode);
        int count = 0;
        for (Integer n : A) {
            if (n != parentNode) {
                count += 1 + countChildren(a, n, currentNode);
            }
        }

        return count;
    }

}
