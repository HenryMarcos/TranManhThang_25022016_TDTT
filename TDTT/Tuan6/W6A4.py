a = list(input().split())
b = {}

for i in range(0, len(a) - 1, 2):
    if a[i] in b:
        b[a[i]].append(a[i + 1])
    else:
        b.update([(a[i], [a[i + 1]])])
print(b)