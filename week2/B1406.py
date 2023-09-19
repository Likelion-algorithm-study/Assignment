# 에디터
# 문제 해결 방법 :
# 첫 번째 시도 - left_stack, right_stack 만들어서 시도 -> 왼쪽 stack이 너무 커지는 경우 - 시간 초과
# 두 번째 시도 - 덱 사용 - 파이썬 덱 모듈

# 시간복잡도 : 


from sys import stdin  # 빠른 입출력
from collections import deque # 덱 모듈

input = stdin.readline

left_stack = deque(input().strip())  # 원래 입력돼있던 문자열
n = int(input()) # 입력할 키 개수
right_stack = deque()  # dequeue 양방향 입출력 가능

for _ in range(n):
    inputKey = input().split()  # 키 입력받기 P, L, D, B
    key = inputKey[0]  # 명령어

    if key == "P":
        value = inputKey[1]
        left_stack.append(value)
    elif key == "L":
        if left_stack:
            right_stack.appendleft(left_stack.pop()) 
    elif key == "D":
        if right_stack:
            left_stack.append(right_stack.popleft())
    elif key == "B":
        if left_stack:
            left_stack.pop()

print(''.join(left_stack + right_stack))  # 전체 합쳐서 문자열로 출력

