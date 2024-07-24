from math import comb

def bridge(n, m):
    return comb(m, n)

T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    print(bridge(n, m))
