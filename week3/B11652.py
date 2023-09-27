# 11652번 - 카드 : 가장 많이 가지고 있는 정수 구하는 프로그램
# 문제 해결 방법 : 수 입력받으면서 dict로 빈도수 세기
# 시간복잡도 : O(N log N)
from sys import stdin
input = stdin.readline

N = int(input())  # 가지고 있는 숫자 카드의 개수

cnt = {}

for _ in range(N):
    num = int(input())

    if num not in cnt:
        cnt[num] = 1
    else:
        cnt[num] += 1


max_ = max(cnt.values())
m = [k for k, v in cnt.items() if v == max_] # value로 key값 찾기
m.sort() # 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력
print(m[0])
