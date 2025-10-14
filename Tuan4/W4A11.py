n = int(input())
if n % 2 != 0:
    print(0)
else:
    e = set()
    i = 2
    while i <= n**0.5:
        if n % i == 0:
            e.add(i)
            e.add((n // i))
        i += 2
    print(len(e) + 1)