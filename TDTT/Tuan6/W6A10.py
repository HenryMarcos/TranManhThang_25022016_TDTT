li = list(map(int, input().split()))
k = int(input())

ans = []

for idx, val in enumerate(li):
    try:
        num = li.index(k - val, idx + 1, len(li))
        ans.append((val, k - val))
    except:
        pass

print(sorted(list(set(ans))))