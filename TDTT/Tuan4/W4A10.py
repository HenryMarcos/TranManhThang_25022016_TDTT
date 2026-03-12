def collatz(num):
    arr = []
    arr.append(num)
    while num != 1:
        if num % 2 == 0:
            num //= 2
        else:
            num = num * 3 + 1
        arr.append(num)
    print(arr)
    return len(arr)

ansnum = 0
anssize = 0
n = int(input()) 
for i in range(1, n + 1):
    r = collatz(i)
    if r > anssize:
        anssize = r
        ansnum = i
print(ansnum, anssize)