x, y = map(int, input().split())

print(bin(x ^ y).count('1'))