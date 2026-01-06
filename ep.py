a = list(map(int, list(input())))
mn = 10
p = -1
if a[0] != 1:
    for i in range(1, len(a)):
        if a[0] > a[i] and a[i] != 0:
            if mn > a[i]:
                mn = a[i]
                p = i
    if p != -1:
        md = a[0]
        a[0] = a[i]
        a[i] = md
    print("".join(map(str, a)))
else:
    for i in range(1, len(a)):
        for j in range(i, len(a)):
            if a[i] > a[j]:
                if mn > a[j]:
                    mn = a[j]
                    p = j
        if p != -1:
            md = a[i]
            a[i] = a[p]
            a[p] = md
            print("".join(map(str, a)))
            break