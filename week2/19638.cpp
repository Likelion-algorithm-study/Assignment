// ██████╗  ██████╗      ██╗
// ██╔══██╗██╔═══██╗     ██║
// ██████╔╝██║   ██║     ██║
// ██╔══██╗██║   ██║██   ██║
// ██████╔╝╚██████╔╝╚█████╔╝
// ╚═════╝  ╚═════╝  ╚════╝
// Created by: haram8009
// Created at: 2023/9/21 (목요일)
// BOJ Number: 19638
// https://boj.kr/19638
// 센티와 마법의 뿅망치

/*
문제풀이:
1. 우선순위 큐 pq 에 거인들의 키를 삽입한다.
2. 최대 T만큼 반복하면서 pq의 top을 확인하여 센티의 키 H보다 크거나 같고 1이 아닐경우 키를 절반으로 줄여서 교체한다.
3. 가장 큰 거인의 키가 1이거나 횟수를 다 썼을 때, 거인나라에서 가장 큰 키가 센티보다 작으면 YES이고, 남은횟수를 전부 사용하고도 센티보다 크면 NO이다.


시간복잡도: O(N * log N + T * log N)
1. 입력 데이터를 받아서 pq에 n번 저장 => O(N * log N)
2. T번 반복하는 while문, 각 루프에서 pq에서 top을 가져오고, 이 값이 H보다 크고 1이 아닌 경우 해당 값을 반으로 나누고 다시 pq에 삽입 * T => O(T * log N)

3. pq에서 top을 가져와서 H와 비교 => 상수 시간
*/

#include <iostream>
#include <queue>

using namespace std;

priority_queue<int> pq;

int main(int argc, char const *argv[])
{
  int N, H, T, t;
  cin >> N >> H >> T;

  while (N--)
  {
    int height;
    cin >> height;
    pq.push(height);
  }

  t = T;
  while (t--)
  {
    int height;
    height = pq.top();

    if (height >= H && height != 1)
    {
      pq.pop();
      height /= 2;
      pq.push(height);
    }
    else
    {
      break;
    }
  }

  int height;
  height = pq.top();

  if (H > height)
  {
    cout << "YES" << endl
         << T - t - 1;
  }
  else
  {
    cout << "NO" << endl
         << height;
  }

  return 0;
}
