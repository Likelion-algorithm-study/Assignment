// ██████╗  ██████╗      ██╗
// ██╔══██╗██╔═══██╗     ██║
// ██████╔╝██║   ██║     ██║
// ██╔══██╗██║   ██║██   ██║
// ██████╔╝╚██████╔╝╚█████╔╝
// ╚═════╝  ╚═════╝  ╚════╝
// Created by: haram8009
// Created at: 2023/9/12 (화요일)
// BOJ Number: 24511
// https://boj.kr/24511

/* 
문제풀이방법 : 

1. 스택은 있어도 없는것과 같으므로 큐 위치에 해당하는 값만 생각한다. 
2. 여러개의 큐가 한개인 것 처럼 생각할 수 있다. 이때 맨 뒤의 큐가 한개의 큐에서 가장 앞(front) 부분이다.
3. 따라서 일단 처음 자료구조에 들어있던 값을 알려줄 때 큐에 해당하는 값만 모아서 스택으로 저장했다가 
4. 한 큐에 순서대로 넣어주고, 입력받는 수열도 들어오는 순서대로 큐에 넣어준다.
5. 큐의 front에서 수열의 길이만큼 값을 꺼낸다.

시간복잡도 : O(N)
*/

#include <iostream>
#include <queue>
#include <stack>

using namespace std;

stack <int> s;
queue <int> q;
bool queuestack[100000]; // 자료구조 정보 리스트

int main(int argc, char const *argv[])
{
  int n, m, input, value;
  cin >> n; 
  for(int i=0; i<n; i++){
    cin >> queuestack[i]; 
  }

  for(int i=0; i<n; i++){
    cin >> input;
    if (queuestack[i]==0){
      s.push(input);
    }
  }

  while (!s.empty())
  {
    q.push(s.top());
    s.pop();
  }
  cin >> m; 
  for (int i=0; i<m; i++){
    cin >> input;
    q.push(input);
  } 
  for(int i=0;i<m;i++){
    cout<< q.front() << ' ';
    q.pop();
  }
  
  return 0;
}
