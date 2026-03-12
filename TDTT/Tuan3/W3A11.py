a, b, c = map(int, input().split())

if a + b > c and a + c > b and b + c > a:
    if a == b == c:
        print("Tam giác đều")
    if a == b or a == c or b == c:
        print("Tam giác cân")
    else:
        print("Tam giác thường")
else:
    print("Không phải tam giác")