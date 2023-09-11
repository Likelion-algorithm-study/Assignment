# 17608 막대기 ( 브론즈 2 ) 
# 문제 풀이 방법 : 
# 막대의 개수 N, N개의 막대 높이가 각각 주어짐 => 스택에 차례대로 넣기
# top에 있는 값을 하나씩 pop 하며 판단 -> top 값보다 작거나 같으면 안 보임 / 크면 보임
# pop()한 값이 기존 top값보다 크면 top값 변경

# 시간복잡도 : O(N)
 
from sys import stdin
input = stdin.readline


N  = int(input()); #막대 개수
s = [int(input()) for _ in range(N)]  #막대 길이 담은 스택 


current_top = s.pop() #첫번째 top 값
cnt = 1  #보이는 막대 개수 

for i in range(len(s)):
    tmp = s.pop()
    if tmp > current_top:
        cnt += 1
        current_top = tmp

print(cnt) 
