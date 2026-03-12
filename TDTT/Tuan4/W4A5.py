n = int(input())
have_42 = False
pre_num = 0
for i in str(n):
    print(i)
    m = int(i)
    print(pre_num * 10 + m)
    if (pre_num * 10 + m == 42):
        pass
    have_42 = (pre_num * 10 + m == 42)
    pre_num = m
if have_42:
    print("I've found the meaning of life!")
else:
    print("It's a joke!")