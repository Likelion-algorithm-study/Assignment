# 반전 요세푸스 순열 
# 문제 해결 방법
# 시간복잡도

from sys import stdin  # 빠른 입출력
from collections import deque # 덱 모듈

input = stdin.readline

N, K, M = map(int, input().split())


q = deque(range(1, N+1))

index_ = 0

while q:
    if index_ // M % 2 == 0:
        for _ in range(K-1):
            q.append(q.popleft())
    else:
        for _ in range(K):
            q.appendleft(q.pop())
    index_ += 1
    print(q.popleft())