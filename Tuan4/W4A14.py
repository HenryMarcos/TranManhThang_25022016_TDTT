def ucln(a, b):
    if b == 0:
        return a
    return ucln(b, a % b)

a1, b1 = map(int, input().split())

print(ucln(a1, b1))