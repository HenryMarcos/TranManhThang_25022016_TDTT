x, y = map(int, input().split())

print(abs(y.bit_length() - x.bit_length()))