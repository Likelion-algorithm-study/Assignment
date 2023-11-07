# 2501번 : 약수 구하기
# 시간복잡도 : O(N)

n, k = map(int, input().split())
lst = []

for i in range(1, n+1):
    if n% i == 0:
        lst.append(i)

if len(lst) >= k:
    print(lst[k-1])
else:
    print(0)