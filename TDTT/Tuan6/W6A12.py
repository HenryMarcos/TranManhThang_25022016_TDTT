a = list(map(int, input().split()))
b = {}

mx = 0
ans = 0

for i in a:
    b[i] = b[i] + 1 if i in b else 1
    if b[i] == mx:
        ans = min(ans, i)
    elif b[i] > mx:
        mx = b[i]
        ans = i

print(ans)