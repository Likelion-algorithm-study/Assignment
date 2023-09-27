# 2108번 - 통계학
# 문제 해결 방법 : 최빈수 -> dict 이용해 카운트 {key=숫자 : value=빈도수}
# 시간복잡도 :

from sys import stdin

input = stdin.readline

N = int(input())  # 수의 개수

arr = []  # 숫자 입력 리스트
cnt = {}  # 숫자 빈도수 세는 dict

for i in range(N):
    num = int(input())  # 수 입력받기

    if num not in cnt:  # cnt dict의 키값으로 num이 없으면 새로 추가
        cnt[num] = 1
    else:
        cnt[num] += 1

    arr.append(num)

max_ = max(cnt.values())
# 최빈값인 것만 따로 리스트 생성
mod = [k for k, v in cnt.items() if max_ == v]
mod.sort()

arr.sort()

# 산술평균 출력 : N개의 수들의 합을 N으로 나눈 값

print(round(sum(arr) / N))

# 중앙값 출력
mid = N // 2
print(arr[mid])

# 최빈값 출력
if(len(mod) > 1):
    mode = mod[1]
else:
    mode = mod[0]
print(mode)

# 범위 출력
print(max(arr) - min(arr))