#!/usr/bin/env python
# https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1

def solve(TC):

    R, C = TC.split(' ')
    S = "\n"
    for r in range(int(R)):
        S1 = ""
        S2 = ""
        for c in range(int(C)):
            if c == 0 and r == 0:
                S1 = ".." 
                S2 = ".."
            else:
                S1 += "+-"
                S2 += "|."
        S += S1+"+\n"
        S += S2+"|\n"

    for c in range(int(C)):
        S += "+-"
    S += "+"

    return S

if __name__ == "__main__":
    T = int(input())
    for t in range(1, T+1):
        TC = input()
        print("Case #%i: %s" % (t, solve(TC)))
