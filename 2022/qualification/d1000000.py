#!/usr/bin/env python
# https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1

def solve(N, S):

    SS = list(map(int, S.split(' ')))
    SS.sort()

    n = 0
    for s in SS:
        if n+1 <= s:
            n += 1
        else:
            pass
        # print(s, n)

    return(n)            

if __name__ == "__main__":

    T = int(input())
    for t in range(1, T+1):
        N = input()
        S = input()
        print("Case #%i: %s" % (t, solve(N, S)))
