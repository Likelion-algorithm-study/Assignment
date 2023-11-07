# 2309번 : 일곱 난쟁이

# 9명 중 7명을 뽑아서 그 합이 100이면 7개의 값 보여줘야 한다.

# 1. 7명 뽑기 - Combi 함수 - 라이브러리 사용 ? 
# 2. 9명 중 7명 -> 2명을 뽑기 (이중for문) , 9명 합에서 2명 합 == 100 이면 2명 제외한 나머지 7명 출력

# 2번 접근 시간복잡도 : O(N^2)


lst = []  # 아홉 난쟁이 담는 곳 

for i in range(9):
    lst.append(int(input()))

lst.sort()  # 오름차순 정렬

total = sum(lst) # 난쟁이 9명 합

# 9명 중 2명 뽑기 i, j
for i in range(len(lst)):  
    for j in range(i+1, len(lst)): 
        # 9명 합에서 2명 합 == 100 이면 2명 제외한 나머지 7명 출력
        if total - (lst[i] + lst[j]) == 100:   
            # i, j번 값 제외하고 난쟁이 출력
            for k in range(len(lst)):
                if(k != i and k != j):
                    print(lst[k])
            exit()  # 하나 출력하면 그냥 끝내기 - 여러 가지 경우 중 아무거나 출력