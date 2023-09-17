# 14235번 크리스마스 선물 
# sort() 로 오름차순 정렬해서 pop()으로 선물 꺼내주기
# 시간복잡도 :  O(n^2 log n) ???

if __name__ == "__main__":
    n = int(input()) #거점지 개수
    present = []  # 선물 담을 배열
    for _ in range(n):

        input_list = list(input().split())


        a = int(input_list.pop(0))
        input_list.sort()


        if( a != 0):
            for i in input_list:
                present.append(int(i))
            present.sort()

        elif (a==0 and len(present) == 0):
            print(-1)
        else:
            print(present.pop())