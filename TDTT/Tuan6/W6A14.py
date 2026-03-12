a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = {}
for i in a:
    c[i] = c[i] + 1 if i in c else 1
for i in b:
    c[i] = c[i] + 1 if i in c else 1

print([x for x in c if c[x] > 1])