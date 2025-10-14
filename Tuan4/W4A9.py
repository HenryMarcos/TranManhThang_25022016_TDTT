def is_that_that(num):
    ar = set()
    ans = 0
    while num > 0:
        ar.add(num % 10)
        num = int(num / 10)
        ans += 1
    return len(ar) == ans 

n = int(input())
ww = []
lnum = 1
while lnum*lnum <= n:
    ww.append(lnum*lnum)
    lnum += 1


si = 0

for i in ww:
    if is_that_that(i):
        si += 1
        print(i, end=" ")
        
if si == 0:
    print("no number")
