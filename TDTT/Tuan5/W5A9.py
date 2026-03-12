def num_length(n: int) -> int:
    ans = 0
    while n > 0:
        ans += 1
        n //= 10
    return ans
