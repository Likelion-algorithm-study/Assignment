#  키로거
# 문제 해결 방법 : 왼쪽, 오른쪽 스택 두 개 만들어서, < 하면 왼쪽으로 넣고 > 하면 오른쪽으로 넣기
# - 하면 왼쪽 스택 pop(), 방향기, 백스페이스 제외하면 다 왼쪽에 넣기
# 시간복잡도 : 


t = int(input())  # 테스트 케이스 개수

for _ in range(t):
    inputKeys = list(input().strip())  # strip()으로 공백 및 개행 문자 제거

    left_stack = []  # '<' 문자를 저장할 스택
    right_stack = []  # '>' 문자를 저장할 스택

    for i in inputKeys:
        if i == "<":
            if left_stack:
                right_stack.append(left_stack.pop())
        elif i == ">":
            if right_stack:
                left_stack.append(right_stack.pop())
        elif i == "-":
            if left_stack:
                left_stack.pop()
        else:
            left_stack.append(i)

    # left_stack과 right_stack을 합친 후 출력
    password = "".join(left_stack + right_stack[::-1])
    print(password)