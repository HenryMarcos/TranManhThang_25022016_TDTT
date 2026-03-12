a, b, c = map(float, input().split())

if a + b > c and a + c > b and b + c > a:
    s = (a + b + c) / 2
    print((s*(s - a)*(s - b)*(s - c))**0.5)
else:
    print("Khong phai 3 canh cua tam giac")