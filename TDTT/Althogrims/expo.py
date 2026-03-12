def expo(x, n):
    if n == 1: return x
    if n == -1: return 1 / x
    if n % 2 != 0:
        return x * expo(x, n - 1)
    return expo(x * x, n // 2)

xx, nn = map(int, input().split())

print(expo(xx, nn))