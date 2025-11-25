def rev_num(num):
    ans = 0
    while num > 0:
        ans *= 10
        ans += num % 10
        num = num // 10
    return ans

n = int(input())
c = 0

while n != rev_num(n):
    n = n + rev_num(n)
    c += 1

print(c, n)