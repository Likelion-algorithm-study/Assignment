# 1764번 - 듣보잡
# 공통 -> 듣못 & 보못
# 문제 해결 방법 : 중복 없다 -> 집합 set에 듣못 명단 넣고, 보못 명단 사람이 듣못에 있으면 answer 명단에 넣기 

# 시간복잡도 : O(MlogM) 


N, M = map(int, input().split())

arr = set()
for i in range(N):
    arr.add(input().strip())

answer = []

for j in range(M):
    p = input().strip()
    if p in arr:
        answer.append(p)

answer.sort() #사전순으로 출력

print(len(answer))
for i in answer:
    print(i)