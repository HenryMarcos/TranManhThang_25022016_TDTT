def out_pos(pos: int, offset: int, mx: int) -> int:
    if pos - offset < 0:
        return pos + mx - offset
    return pos - offset

a = tuple(map(int, input().split()))
k = int(input())

for i in range(len(a)):
    print(a[out_pos(i, k, len(a))])