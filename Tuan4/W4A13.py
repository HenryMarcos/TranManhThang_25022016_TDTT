def sumDiv(num):
    ans = 1
    for i in range(2, int(num**.5) + 1):
        if num % i == 0:
            ans += i
            if num // i != i:
                ans += num // i
    return ans

a, b = map(int, input().split())
if sumDiv(a) == b and a == sumDiv(b):
    print("true")
else:
    print("false")