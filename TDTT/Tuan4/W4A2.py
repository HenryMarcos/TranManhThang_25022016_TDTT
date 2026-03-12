def isPrime(num):
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True

n = 0
while True:
    try:
        n = int(input())
        if n > 0:
            break
    except:
        pass
if isPrime(n):
    print("Is Primu")
else:
    print("No")
