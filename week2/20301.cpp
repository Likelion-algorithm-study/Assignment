// ██████╗  ██████╗      ██╗
// ██╔══██╗██╔═══██╗     ██║
// ██████╔╝██║   ██║     ██║
// ██╔══██╗██║   ██║██   ██║
// ██████╔╝╚██████╔╝╚█████╔╝
// ╚═════╝  ╚═════╝  ╚════╝
// Created by: haram8009
// Created at: 2023/9/19 (화요일)
// BOJ Number: 20301
// https://boj.kr/20301
// 반전 요세푸스

/*
문제풀이:

1. deque을 k-1만큼 회전시켜서 front/back의 값을 출력하고 해당 값을 꺼내기를 반복한다. (k번째 수)
2. m번째 원소를 꺼냈다면 회전 방향을 바꾼다.

시간복잡도: O(n)
1. 크기 n인 덱 생성 => O(n)
2. 덱 회전 => O(n * k) == O(n)

*/

#include <iostream>
#include <deque>

using namespace std;

int main(int argc, char const *argv[])
{
  deque<int> dq;
  int n, k, m, _m = 0;

  cin >> n;
  cin >> k;
  cin >> m;
  for (int i = 1; i <= n; i++)
  {
    dq.push_back(i); // 덱 채우기
  }

  bool forward = true;
  while (dq.size() > 0)
  {
    if (_m == m)
    {
      _m = 0;
      forward = !forward;
    }

    if (forward)
    {
      for (int i = 0; i < k - 1; i++)
      {
        dq.push_back(dq.front());
        dq.pop_front();
      }
      cout << dq.front() << endl;
      dq.pop_front();
    }
    else
    {
      // backward 라면
      for (int i = 0; i < k - 1; i++)
      {
        dq.push_front(dq.back());
        dq.pop_back();
      }
      cout << dq.back() << endl;
      dq.pop_back();
    }

    _m++;
  }

  return 0;
}
