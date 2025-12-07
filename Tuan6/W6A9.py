dic1list = list(input().split())
dic2list = list(input().split())

dic1 = {}
dic2 = {}

for i in range(0, len(dic1list) - 1, 2):
    dic1[dic1list[i]] = dic1list[i + 1]

for i in range(0, len(dic2list) - 1, 2):
    dic2[dic2list[i]] = dic2list[i + 1]

for i in dic2:
    if i in dic1:
        dic1[i] += dic2[i]
    else:
        dic1.update([(i, dic2[i])])

print(dict(sorted(dic1.items())))

