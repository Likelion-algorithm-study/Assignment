// ██████╗  ██████╗      ██╗
// ██╔══██╗██╔═══██╗     ██║
// ██████╔╝██║   ██║     ██║
// ██╔══██╗██║   ██║██   ██║
// ██████╔╝╚██████╔╝╚█████╔╝
// ╚═════╝  ╚═════╝  ╚════╝
// Created by: haram8009
// Created at: 2023/9/12 (화요일)
// BOJ Number: 17608
// https://boj.kr/17608

/* 
문제풀이방법 : 

1. 시선이 오른쪽이기 때문에 스택에 넣어서 나중에 들어온 값부터 꺼낸다.
2. 처음 꺼낸 값부터 그 값보다 큰 숫자가 나오는 경우만 센다.

시간복잡도 : O(N)
*/

#include <iostream>
#include <stack>

using namespace std;

int main(int argc, char const *argv[])
{
  int n, value;
  cin >> n;

  stack<int> s;

  while(n--){
    cin >> value;
    s.push(value);
  }

  int flag = 0;
  int cnt = 0;

  while(!s.empty()){
    int pop = s.top();
    s.pop();
    if (pop > flag){
      flag = pop;
      cnt++;
    }
  }

  cout << cnt << endl;
  return 0;
}
