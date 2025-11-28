import math
import numpy as np

def isPrime(num):
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
    return True

prime = []

def makePrime(max_num):
    prime.extend([True] * max_num)
    prime[0:2] = False
    for i in range(2, int(math.sqrt(max_num)) + 1):
        if prime[i]:
            prime[i*i:max_num + 1:i] = False

a, b = map(int, input().split())
makePrime(b)
ans = 0
#for i in range(a, b + 1):
#    if isPrime(i):
#        ans += i
#print(ans)

