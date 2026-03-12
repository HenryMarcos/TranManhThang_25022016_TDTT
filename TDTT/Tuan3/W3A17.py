a, b, c, d = map(float, input().split())

if b % a == 0:
    p = b / a
    if b * p == c and c * p == d:
        print("Yes")
    else:
        print("No")
else:
    print("No")