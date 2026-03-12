a = list(input().split())
b = {}
for i in a:
    if i in b:
        b[i] += 1
    else:
        b.update([(i, 1)])
print(b)