# 2776번 - 암기왕 -> 해결 ing 

from sys import stdin
input = stdin.readline

t = int(input())  # 테스트 케이스 개수

for _ in range(t):
    n = int(input())  # 수첩1 정수 개수

    for i in range(n):
        note1 = list(map(int, input().split()))

    print(note1)
    m = int(input())

    for j in range(m):
        note2 = list(map(int, input().split()))
    print(note2)
    
    
