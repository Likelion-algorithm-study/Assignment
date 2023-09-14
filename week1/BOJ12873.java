package week1;

import java.util.*;

public class BOJ12873 {
    private static int pow3Mod3(int i, int mod) {
        return ((i%mod) * (i%mod) * (i%mod)) % mod;
        // a^3%mod = (a*a*a)%mod = (a^2)%mod * a%mod = (a*a)%mod * a%mod = a%mod * a%mod * a%mod
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();

        List<Integer> arrList = new LinkedList<>();
        for(int i = 1; i <= people; i++) { // 1 - 10. 총 10번
            arrList.add(i);
        }

        int buffer = 0;
        for (int i = 1; i < people; i++) { // 1 - 9. 총 9번. 10번까지 할 필요없다. 10번째는 요소 하나만 남기 때문에 그 요소를 출력하면 끝이다.
            int removeIndex = (buffer + pow3Mod3(i, arrList.size()) - 1) % arrList.size();
            // 사람 탈락 후 첫 인덱스로 돌아가는 것이 아니라 탈락한 사람 바로 다음부터 게임 진행해야 하므로 buffer 를 더한 후 현재 사람 수로 mod. 이 때 인덱스로 arrList 로부터 사람을 탈락시킬 것이므로 -1

            if(removeIndex < 0) { // removeIndex < 0 즉 -1 이 되는 경우는 마지막 경우임.
                removeIndex += arrList.size(); // 이 경우 1 (=arrList.size())을 더해 0 으로 만든다. 인덱스 0 으로 사용할 수 있다.
            }
            arrList.remove(buffer=removeIndex);
        }

        System.out.println(arrList.get(0));
    }
}

// 1^3%10 = (1*1*1)%10   = 1%10   = 1 = (1%10 * 1%10 * 1%10) % 10 = (1*1*1)%10
// 2^3%9  = (2*2*2)%9    = 8%9    = 8 = (2%9  * 2%9  * 2%9) % 9   = (2*2*2)%9
// 3^3%8  = (3*3*3)%8    = 27%8   = 3 = (3%8  * 3%8  * 3%8) % 8   = (3*3*3)%8
// ...
// 10^3%1 = (10*10*10)%1 = 1000%1 = 0 = (10%1 * 10%1 * 10%1) % 1 = (0*0*0)%1

// 10
// 1단계  1^3 .
//           1 2 3 4 5 6 7 8 9 0 (1 % 10 = 1)   ( 0 + 1 - 1 ) % 10 = 0 % 10 = 0
// 2단계  2^3               .
//           2 3 4 5 6 7 8 9 0   (8 % 9 = 8)    (
// 3단계  3^3   .
//           2 3 4 5 6 7 8 0     (27 % 8 = 3)
// 4단계  4^3   .
//           2 4 5 6 7 8 0       (64 % 7 = 1)
// 5단계  5^3           .
//           2 5 6 7 8 0         (125 % 6 = 5)
// 6단계  6^3 .
//           2 5 6 7 8           (216 % 5 = 1)
// 7단계  1^3     .
//           5 6 7 8             (343 % 4 = 3)
// 8단계  2^3 .
//           5 6 8               (512 % 3 = 2)
// 9단계  3^3 .
//           6 8                 (729 % 2 = 1)
// 0단계  4^3
//           8                   (1000 % 1 = 0)
