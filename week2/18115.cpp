// ██████╗  ██████╗      ██╗
// ██╔══██╗██╔═══██╗     ██║
// ██████╔╝██║   ██║     ██║
// ██╔══██╗██║   ██║██   ██║
// ██████╔╝╚██████╔╝╚█████╔╝
// ╚═════╝  ╚═════╝  ╚════╝
// Created by: haram8009
// Created at: 2023/9/19 (화요일)
// BOJ Number: 18115
// https://boj.kr/18115
// 카드놓기

/*
문제풀이:

1. 기술을 입력받고 뒤에서부터 읽는다.
2. 1부터 덱에 삽입하는데, 기술이 1이면 front, 2이면 앞에서 두번째자리, 3이면 back에 삽입한다.
3. 덱을 앞에서부터 차례대로 출력한다.

시간복잡도: O(n)
1. 스텍에 원소 삽입 O(n)

*/

#include <iostream>
#include <stack>
#include <deque>

using namespace std;

int main(int argc, char const *argv[])
{
  stack<int> s;
  deque<int> dq;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++)
  {
    int input;
    cin >> input;
    s.push(input);
  }

  int skill;
  for (int i = 0; i < n; i++)
  {
    int num = i + 1;
    skill = s.top();
    s.pop();
    switch (skill)
    {
    case 1:
      dq.push_front(num);
      break;
    case 2:
      // 2번째 자리에 원소 넣기
      int tmp;
      tmp = dq.front();
      dq.pop_front();
      dq.push_front(num);
      dq.push_front(tmp);
      break;
    case 3:
      dq.push_back(num);
      break;
    default:
      break;
    }
  }

  for (int i = 0; i < n; i++)
  {
    cout << dq.front() << " ";
    dq.pop_front();
  }

  return 0;
}
