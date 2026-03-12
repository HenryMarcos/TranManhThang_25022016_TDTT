import numpy as np
import math

n = 3000
prime = np.ones(n + 1, dtype=bool)
prime[0:2] = False

for p in range(2, int(math.sqrt(n)) + 1):
    if prime[p]:
        prime[p*p:n+1:p] = False

print(np.nonzero(prime)[0].tolist())