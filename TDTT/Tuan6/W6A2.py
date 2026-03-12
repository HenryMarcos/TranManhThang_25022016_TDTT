sum = 0
a = list(map(int, input().split()))
b = []
for i in a:
    sum += i
    b.append(sum)
print(b)
