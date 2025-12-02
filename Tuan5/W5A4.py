def isPerfect(n: int) -> bool:
    if n == 1: return False
    divSum = 1
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            divSum += i
            if n / i != i:
                divSum += n / i
    return divSum == n

m = int(input())
print(isPerfect(m))