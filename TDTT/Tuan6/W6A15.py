base_dic = input().split()
k = int(input())
dic = {}
for i in range(0, len(base_dic) - 1, 2):
    if int(base_dic[i + 1]) > k:
        dic[base_dic[i]] = base_dic[i + 1]

print(dic)

