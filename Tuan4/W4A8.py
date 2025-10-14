def rev_num(num):
    ans = 0
    while num > 0:
        ans *= 10
        ans += num % 10
        num = int(num / 10)
    return ans

n = int(input())

while n != rev_num(n):
    n = n + rev_num(n)

print(rev_num(n))