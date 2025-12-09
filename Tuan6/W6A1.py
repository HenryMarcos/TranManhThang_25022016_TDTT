a = list(map(int, input().split()))
b = {}
ans = []
for i in a:
    if not (i in b):
        b.update([(i, True)])
        ans.append(i)
print(ans)
