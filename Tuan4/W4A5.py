n = int(input())
have_42 = False
for i in range(n):
    m = int(input())
    have_42 = (m == 42)
if have_42:
    print("I've found the meaning of life!")
else:
    print("It's a joke!")