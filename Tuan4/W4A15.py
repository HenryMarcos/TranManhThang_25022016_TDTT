am, amleg = map(int, input().split())
chicken_num = 0
hav = False
while chicken_num <= am:
    if chicken_num * 2 + (am - chicken_num) * 4 == amleg:
        print(chicken_num, am - chicken_num)
        hav = True
        break
    chicken_num += 1
if not hav:
    print("invalid")