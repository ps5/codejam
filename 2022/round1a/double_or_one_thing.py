#!/usr/bin/env python
# https://codingcompetitions.withgoogle.com/codejam/round/0000000000877ba5/0000000000aa8e9c

def solve(S):

    s = ""
    for i in range(1, len(S)):
        s += S[i-1]
        if S[i-1]<S[i]:
            s += S[i-1] # once again (highlight)
            # special case: PEEL
            if S[i]>S[i-1]: # L > E
                x = S[i-1] # E
                ii = i-2
                ss = "" # highlight all previous Es
                while (S[ii] == x and ii >= 0):
                    ss += x
                    ii -= 1
                s += ss
        
    s += S[-1:]
    return ("%s" % (s))

if __name__ == "__main__":
    T = int(input())
    for t in range(1, T+1):
        S = input()
        print("Case #%i: %s" % (t, solve(S)))
