import java.util.*;

/**
           1         - 0
       1       2     - 1
     1   2   3   4   - 2
    1 2 3 4 5 6 7 8  - 3
    
    [제한사항]
    N은 2 이상 2^20 이하 -> 이진트리
    A, B는 N 이하의 자연수 -> N=2인 경우, A=1, B=2 또는 A=2, B=1 
    
    [유추할 수 있는 내용]
    트리의 레벨은 N이 2의 몇 제곱수인지다. => 먼저 계산해서 레벨을 알 수 있을듯 (/2의 결과값이 1이 될 때까지 반복한 횟수)
    [1, 1, 2] >>> 1=1*2-1, 2=1*2
    
    [자식노드 계산 방식]
    왼자 = 부모노드 * 2 - 1 (그니까 무조건 홀수)
    오자 = 부모노드 * 2 (그니까 무조건 짝수)
    
    [만난다는 의미는?]
    두 노드가 같은 부모 노드를 가질 때!
    그러니까, 우리는 왼자와 오자의 부모 노드를 알면 된다
    
    [방법은?]
    트리의 순회는 항상 루트부터 시작
    왼자의 부모노드 = 왼자 / 2 + 1
    오자의 부모노드 = 오자 / 2
    
    [해볼까?]
    1) N = 2, A = 1, B = 2 // [1, 1, 2]
        정답 = 0;
        A의 부모 = A / 2 + 1 = 1
        B의 부모 = B / 2 = 1
        정답++
        부모가 같은 값이 나왔다 -> return 1
        
    2) N = 8, A = 4, B = 7
        정답 = 0;
        A의 부모 = 4 / 2     = 2
        B의 부모 = 7 / 2 + 1 = 4
        정답++; // 정답 = 1
        
        이어서,
        A의 부모 = 2 / 2 = 1
        B의 부모 = 4 / 2 = 2
        정답++; // 정답 = 2
        
        이어서,
        A의 부모 = 1 / 2 + 1 = 1
        B의 부모 = 2 / 2 = 1
        정답++;
        부모가 같은 값이 나왔다 => return 3
**/



class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        
        int aParent = a;
        int bParent = b;
        
        while(aParent != bParent) {
            if(aParent % 2 == 0) aParent = aParent / 2;
            else aParent = aParent / 2 + 1;
            
            if(bParent % 2 == 0) bParent = bParent / 2;
            else bParent = bParent / 2 + 1;
            
            answer++;
        }

        return answer;
    }
}