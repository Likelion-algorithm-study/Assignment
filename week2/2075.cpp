// ██████╗  ██████╗      ██╗
// ██╔══██╗██╔═══██╗     ██║
// ██████╔╝██║   ██║     ██║
// ██╔══██╗██║   ██║██   ██║
// ██████╔╝╚██████╔╝╚█████╔╝
// ╚═════╝  ╚═════╝  ╚════╝
// Created by: haram8009
// Created at: 2023/9/20 (수요일)
// BOJ Number: 2075
// https://boj.kr/2075
// N번째 큰 수

/*
문제풀이:
1. 오름차순 우선순위큐 pq
2. 처음 5개 원소는 그냥 삽입한다.
3. 그 이상부터는 현재 pq의 top보다 큰 숫자만 삽입하고, 삽입할땐 원소 한개를 pop하면서 원소의 개수를 5개로 유지한다.
4. 마지막 원소까지 삽입한 뒤 pq의 top은 5번째로 큰 숫자이다.

시간복잡도: O(n^2 * log n)

1. 추가된 원소의 개수는 n x n
1. 우선순위 큐의 크기가 n보다 작은 경우, 원소를 그대로 추가 => O(log n), 원소를 추가할 때 우선순위 큐의 크기가 n 이상이면 현재 큐의 최소값 (pq.top)와 비교하여 더 큰 값이 들어온 경우 최소값을 교체 => O(log n)

*/

#include <iostream>
#include <queue>

using namespace std;

priority_queue<int, vector<int>, greater<int>> pq;

int main(int argc, char const *argv[])
{
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);

  int n, m, num;
  cin >> n;
  m = n * n;
  while (m--)
  {
    cin >> num;
    if (pq.size() < n)
    {
      pq.push(num);
    }
    else
    {
      if (pq.top() < num)
      {
        pq.pop();
        pq.push(num);
      }
    }
  }

  cout << pq.top();
  return 0;
}
