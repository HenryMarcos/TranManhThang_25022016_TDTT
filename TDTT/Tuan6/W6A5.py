a = {'positives': 0, 'negatives': 0, 'zeros': 0}

b = list(map(int, input().split()))
for i in b:
    if i > 0:
        a['positives'] += 1
    elif i < 0:
        a['negatives'] += 1
    else:
        a['zeros'] += 1
print(a)