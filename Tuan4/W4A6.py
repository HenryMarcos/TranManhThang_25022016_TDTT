import math
import numpy as np

def makePrime(max_num):
    prime = np.ones(max_num + 1, dtype=bool)
    prime[0:2] = False
    for i in range(2, int(math.sqrt(max_num)) + 1):
        if prime[i]:
            prime[i*i:max_num + 1:i] = False
    return prime

a, b = map(int, input().split())
new_prime = makePrime(b)

value_array = np.nonzero(np.array(new_prime[a:]))[0].tolist()
value_array = np.array(value_array) + a

print(sum(value_array))


