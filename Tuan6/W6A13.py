a = list(input().split())
b = {}
c = {}
for i in range(0, len(a) - 1, 2):
    b[a[i]] = a[i + 1]
for i in b:
    c[b[i]] = i

print(c)