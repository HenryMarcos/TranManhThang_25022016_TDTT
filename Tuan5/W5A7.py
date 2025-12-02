a, b, c = input().split()
a = float(a)
b = float(b)
ans = 0
match c:
    case '+':
        ans = a + b
    case '-':
        ans = a - b
    case '*':
        ans = a * b
    case '/':
        ans = a / b
print(round(ans, 2))
