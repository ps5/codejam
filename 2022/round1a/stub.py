#!/usr/bin/env python3
# Equal Sum 
# https://codingcompetitions.withgoogle.com/codejam/round/0000000000877ba5/0000000000aa8fc1

def solve(sa, sb):

    l = list(map(int,(sa + " " + sb).split(" ")))
    l.sort()
    h = sum(l) / 2
    # print(h, l)

    j = len(l)    
    jj = j
    while jj > 0:
        a = []
        while (j>0):
            j -= 1
            x = l[j]
            if sum(a) + x == h:
                a.append(x)
                # print(a)
                a.sort()
                s = ' '.join(str(e) for e in a)
                return s 

            if sum(a) + x < h:
                if len(a) == 0:
                    jj = j # first element < sum/2
                a.append(x)
                # print(j, a)

        jj -= 1 # try next
        j = jj
        break
    return ""

if __name__ == "__main__":
    T = int(input())
    for t in range(1, T+1):
        N = input()
        if N == "-1": # error
            break 
        # output N integers between 1 and 10^9
        sa = "1"
        for i in range(2, int(N) + 1):
            sa += " " + str(i)
        print(sa, flush=True)
        # read set B
        sb = input()
        if sb == "-1": # error
            break 
        # f = open("t.txt","a")
        # f.write(sb)
        # f.close()
        print(solve(sa, sb), flush=True)
