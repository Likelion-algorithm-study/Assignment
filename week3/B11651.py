# 11651번 - 좌표 정렬하기 2
# 문제 해결 방법: 1. 버블정렬(-> 시간초과) 2. 셸 정렬 O(n^2)(-> 시간초과) 3. 힌트 얻고 병합정렬로 접근
# 병합정렬 :여러 개의 정렬된 집합을 병합하여 하나의 정렬된 집합으로 만드는 정렬 방법(재귀)
# 시간 복잡도 O(nlogn)

from sys import stdin
input = stdin.readline

def mergeSort(arr):

    if len(arr) < 2:
        return arr;

    mid = len(arr)//2;

    l_arr = mergeSort(arr[:mid]);
    h_arr = mergeSort(arr[mid:]);

    merged_arr = []
    l = h = 0

    while l < len(l_arr) and h < len(h_arr):
        if l_arr[l][1] < h_arr[h][1]:
            merged_arr.append(l_arr[l])
            l += 1
        elif l_arr[l][1] == h_arr[h][1] and l_arr[l][0] < h_arr[h][0]:
            merged_arr.append(l_arr[l])
            l += 1
        else:
            merged_arr.append(h_arr[h])
            h += 1
    merged_arr += l_arr[l:]
    merged_arr += h_arr[h:]

    return merged_arr

if __name__ == "__main__":
    n = int(input()) #점의 개수
    arr = [] #좌표 받는 리스트

    for _ in range(n):
        xy = list(map(int, input().split()))
        arr.append(xy)

    arr = mergeSort(arr)

    for i in range(len(arr)):
        print(arr[i][0], arr[i][1])