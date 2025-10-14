def isPrime(num):
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True
n = int(input())
ans = 0
for i in range(2, int(n / 2) + 1):
    
    if n % i == 0 and isPrime(i):
        ans = i

if ans >= 2:
    print(ans)