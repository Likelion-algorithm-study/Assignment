// ██████╗  ██████╗      ██╗
// ██╔══██╗██╔═══██╗     ██║
// ██████╔╝██║   ██║     ██║
// ██╔══██╗██║   ██║██   ██║
// ██████╔╝╚██████╔╝╚█████╔╝
// ╚═════╝  ╚═════╝  ╚════╝
// Created by: haram8009
// Created at: 2023/9/18 (월요일)
// BOJ Number: 14235
// https://boj.kr/14235
// 크리스마스 선물

/*
문제 풀이 방법:
아이들을 만날 때 마다 가장 가치가 큰 선물을 줘야하므로 입력할 때 정렬이 되는 우선순위 큐를 이용한다. (기본 내림차순)

시간 복잡도: O(n * log n)
1. 큐에 pop/push 하는 경우=> O(log n)
2. while문 반복 횟수 => O(n)
*/

#include <iostream>
#include <queue>

using namespace std;

priority_queue<int> pq;

int main(int argc, char const *argv[])
{
  int n, a, tmp;
  cin >> n;
  while (n--)
  {
    cin >> a;
    if (a)
    { // a가 0이 아니라면
      for (int i = 0; i < a; i++)
      {
        cin >> tmp;
        pq.push(tmp);
      }
      continue;
    }

    if (!pq.size())
    {
      // 만약 주머니에 선물이 없는경우
      cout << -1 << endl;
      continue;
    }
    cout << pq.top() << endl;
    pq.pop();
  }

  return 0;
}
