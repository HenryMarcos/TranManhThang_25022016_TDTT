name = input("Ten chu ho: ")
pre = int(input("Chi so thang truoc: "))
nnow = int(input("Chi so thang nay: "))

sum = 0.0
minus = 0
current = 0

nnow = nnow - pre

if nnow > 400:
    sum += (nnow - 400) * 3460
    nnow = 400
if nnow > 300:
    sum += (nnow - 300) * 3350
    nnow = 300
if nnow > 200:
    sum += (nnow - 200) * 2998
    nnow = 200
if nnow > 100:
    sum += (nnow - 100) * 2380
    nnow = 100
if nnow > 50:
    sum += (nnow - 50) * 2050
    nnow = 50
if nnow > 0:
    sum += nnow * 1984
print(int(sum * 1.08))