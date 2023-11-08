# 모든 순열

# N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을
# 사전순으로 출력하는 프로그램을 작성하시오.


n = int(input())
lst = []

# dfs 깊이 우선 탐색
def dfs(depth):
  # 깊이가 n이 되면 종료
  if depth == n:
    print(*lst) # 리스트 요소 한번에 출력
    return

  for i in range(1, n + 1):
    # 아직 사용하지 않은 숫자면
    if i not in lst:
      lst.append(i)  # 사용할 숫자 넣기
      dfs(depth + 1)    # 다음 깊이로 dfs 호출
      lst.pop()      # 사용한 숫자 꺼내기
dfs(0)