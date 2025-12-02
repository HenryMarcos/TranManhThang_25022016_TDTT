a, b = map(float, input().split())

if a == 0 and b == 0:
    print("Vô số nghiệm")
elif a == 0 and b != 0:
    print("Vô nghiệm")
else:
    print(round(-b / a, 2))