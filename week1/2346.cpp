// ██████╗  ██████╗      ██╗
// ██╔══██╗██╔═══██╗     ██║
// ██████╔╝██║   ██║     ██║
// ██╔══██╗██║   ██║██   ██║
// ██████╔╝╚██████╔╝╚█████╔╝
// ╚═════╝  ╚═════╝  ╚════╝
// Created by: haram8009
// Created at: 2023/9/13 (수요일)
// BOJ Number: 2346
// https://boj.kr/2346

/* 
문제풀이방법 : 

1. 덱을 사용하고, 처음 입력받을 때 몇번째 풍선인지 기억하기위해 구조체를 사용한다.
2. 풍선을 터트린다. 즉, 덱의 front를 꺼내고 몇 번째 풍선이었는지 출력한다.
3. 풍선속 종이의 값만큼 덱의 앞에서 뒤로, 혹은 뒤에서 앞으로 원소를 옮김으로써 덱을 '회전'시킨다.

시간복잡도 : O(N) ???
*/
#include <iostream>
#include <deque>

using namespace std;

struct info
{
  int idx, value;
};

deque<info> deq;
int n;

int main(int argc, char const *argv[])
{
  cin >> n;
  for (int i = 1, num; i <= n; i++)
  {
    cin >> num;
    deq.push_back({i , num});
  }


  while(!deq.empty()){
    cout << deq.front().idx << " ";
    int value = deq.front().value;
    deq.erase(deq.begin());

    if (value > 0){
      for (int i = 0; i < value-1; i++)
      {
        deq.push_back(deq.front());
        deq.erase(deq.begin());
      }      
    } else {
      for (int i = 0; i < -value; i++)
      {
        deq.push_front(deq.back());
        deq.erase(deq.end()-1);
      }
      
    }

  }
  return 0;
}
