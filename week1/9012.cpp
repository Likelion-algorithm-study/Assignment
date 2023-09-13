// ██████╗  ██████╗      ██╗
// ██╔══██╗██╔═══██╗     ██║
// ██████╔╝██║   ██║     ██║
// ██╔══██╗██║   ██║██   ██║
// ██████╔╝╚██████╔╝╚█████╔╝
// ╚═════╝  ╚═════╝  ╚════╝
// Created by: haram8009
// Created at: 2023/9/13 (수요일)
// BOJ Number: 9012
// https://boj.kr/9012
 
/* 
문제풀이방법 : 

1. 한 라인을 받아서 괄호의 형태에 따라 flag 값을 더하거나 뺀다.
2. 한 라인이 끝나고 flag 값을 확인했을 때 0이 아니면 유효하지 않다.
3. 이때 flag가 0인 상태에서 ')' 문자를 받은경우 무조건 무효하다.

시간복잡도 : O(N)
*/
#include <iostream>
#include <stack>

using namespace std;

int n;
string line;
int main(int argc, char const *argv[])
{
  ios_base::sync_with_stdio(0);
  cin.tie(0); cout.tie(0);
  
  cin >> n;
  cin.ignore();

  while(n){
    int flag=0;
    getline(cin, line);
    for (int i = 0; i < line.length(); i++)
    {
      if (line[i]=='('){
        flag++;
      } else if (flag>0 && line[i]==')') {
        flag--;
      } else if (flag==0 && line[i]==')'){
        flag=-1;
        break;
      }
    }

    if (flag==0)
    {
      cout << "YES" << endl;
    } else
    {
      cout << "NO" << endl;
    }
    n--;
  }


  return 0;
}