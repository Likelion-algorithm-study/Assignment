# 13417번 카드 문자열
# 문제 해결 방법 : 뒤로 붙이는 경우 => 정렬된 카드 배열의 맨끝 카드보다 같거나 클 경우, 첫번째 카드보다 클 경우

# 시간복잡도 : 

import sys
n = int(sys.stdin.readline())

if __name__ == "__main__":
    t = int(input()) #테스트 케이스 개수

    for _ in range(t):
        clear = False
        answer = []  # 답

        while(clear is False):
            n = int(input())

            card = list(input().split())


            first = card.pop(0)  # 첫번째 카드
            answer.append(first)

            for i in card:
                if (i >= answer[-1] or i > answer[0]):
                    answer.append(i)
                else:
                    answer.insert(0, i)
            output =""
            for j in answer:
                output += j
            print(output)
            clear = True