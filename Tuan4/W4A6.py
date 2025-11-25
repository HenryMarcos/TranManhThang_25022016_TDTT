def isPrime(num):
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True

a, b = map(int, input().split())
ans = 0
for i in range(a, b + 1):
    if isPrime(i):
        ans += i
print(ans)

def sumof(a, b):
    return a + b

