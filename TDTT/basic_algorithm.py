d, m, y = map(int, input().split())
d_list = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
if (y % 4 == 0 and y % 100 != 0) or (y % 400 == 0): d_list[2] = 29
if m > 12 or d_list[m] < d: print("Invalid Date")
else:
    d += 1
    if d_list[m] < d:
        d = 1
        m += 1
        if m > 12:
            y += 1
            m = 1
    print(f"{d}/{m}/{y}")