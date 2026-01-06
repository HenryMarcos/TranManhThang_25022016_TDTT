def comb(n: int, k: int) -> int:
    if k == 1: return n
    if n == k: return 1
    return comb(n - 1, k - 1) + comb(n - 1, k)

print(comb(5, 3))