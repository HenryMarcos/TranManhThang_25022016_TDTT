a = float(input())

a1 = int(a)
a2 = int(a) + 1 if a > int(a) else a
a3 = int(a) + 1 if a - int(a) >= 0.5 else int(a)

print(a1, a2, a3)