s = list(input())
ch = s[0]
c = 1
ans = ""
for i in s[1:]:
    if i != ch:
        ans += str(c) + ch
        ch = i
        c = 0
    c += 1
ans += str(c) + ch
print(ans)
