# 2751번 - 수 정렬하기 2
# 문제 해결 방식 : sort()를 이용
# 시간복잡도 : O(nlog(n)) -> sort()

from sys import stdin
input = stdin.readline

n = int(input())
arr = []

for _ in range(n):
    arr.append(int(input()))

arr.sort()

for i in arr:
    print(i)