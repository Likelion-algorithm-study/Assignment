# 9012 괄호 ( 실버 4 ) : 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내기
# 문제 풀이 방법: 
# 스택 두 개 만들어서, pop()해가며 판단 
# stack - 괄호 string 입력받아 문자열 하나씩 원소로 하는 리스트 생성
# stack2 - 괄호 stack을 pop해서 받거나 제거하는 스택
# stack에서 하나씩 pop() 해서 괄호가 완성되면 (ex: stack2에 ) 가 있는데, stack의 top값은 ( ==> 괄호 완성) stack2 pop()
# 괄호 완성 안 되면 (ex: stack top값이 닫힌괄호일 때) pop한 stack top값을 stack2에 append()
# stack의 크기가 1보다 클 때까지 반복 
#  




from sys import stdin
input = stdin.readline  #빠른 입력

if __name__ == "__main__":
    T = int(input())  # 테스트 케이스
    answer = []  # yes/no 담을 리스트

    for _ in range(T):
        stack = list(input().rstrip())  #위에 /n 들어가는 것 해결
        stack2 = []

        while len(stack) > 1:
            
            stack_top = stack.pop() # stack의 top값

            if stack_top == "(" and len(stack2) == 0: # No
                stack.append(stack_top)
                break
            elif stack_top == "(" and len(stack) == 0:
                break
            elif stack_top == "(" and len(stack2) != 0:
                stack2.pop()
            else:
                stack2.append(stack_top)
                
        stack_top = stack.pop()  #마지막 stack 값 pop함
        
        if stack_top == "(" and len(stack2) == 0:
            stack.append(stack_top)
        elif stack_top == "(" and len(stack2) != 0:
            stack2.pop()
        else:
            stack2.append(stack_top)

        if (len(stack) == 0 and len(stack2) != 0) or (len(stack) != 0 and len(stack2) == 0):
            answer.append("NO")
        else:
            answer.append("YES")

    for i in answer:
        print(i)