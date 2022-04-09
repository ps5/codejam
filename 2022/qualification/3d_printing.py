#!/usr/bin/env python
# https://codingcompetitions.withgoogle.com/codejam/round/0000000000876ff1

def solve(L1, L2, L3):

    C1, M1, Y1, K1 = L1.split(' ')
    C2, M2, Y2, K2 = L2.split(' ')
    C3, M3, Y3, K3 = L3.split(' ')
    C = min(int(C1), int(C2), int(C3))
    M = min(int(M1), int(M2), int(M3))
    Y = min(int(Y1), int(Y2), int(Y3))
    K = min(int(K1), int(K2), int(K3))

    if (C+M+Y+K < 1000000):
        return "IMPOSSIBLE"

    if (C+M+Y+K > 1000000):
        K = 1000000 - (C+M+Y)
        if K < 0:
            K = 0
    if (C+M+Y > 1000000):
        Y = 1000000 - (C+M)
        if Y < 0:
            Y = 0
    if (C+M > 1000000):
        M = 1000000 - (C)

    return "%s %s %s %s" % (C, M, Y, K)

if __name__ == "__main__":
    T = int(input())
    for t in range(1, T+1):
        L1 = input()
        L2 = input()
        L3 = input()
        print("Case #%i: %s" % (t, solve(L1, L2, L3)))
