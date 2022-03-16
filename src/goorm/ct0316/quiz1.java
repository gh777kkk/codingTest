package goorm.ct0316;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
로마의 황제가 전쟁에서 패해 N-1명의 병사들과 함께 출구가 없는 동굴에
포위당했다고 합니다. 모든 병사들은 외적에 항복하느니 차라리 자살하자고
결의했고, 포위당한 N명의 사람들이 모두 원형으로 둘러선 뒤 순서대로
자살하기로 했습니다.

한 사람이 자살하면, 다음에는 그사람으로부터 시계 방향으로 K번째에 살아
있는 사람이 자살하는 것입니다. 항제는 자신과 다른 병사 하나만이 살아남았을
때 이들은 마음을 바꾸어 외적에 항복하여 목숨은 부지했다고 합니다.

마지막 두 사람 중 하나가 되기 위해 황제는 첫 번째 자살한 병사로부터 몇 자리
떨어진 곳에 있어야 할지를 구하는 프로그램을 작성하는 것이 목표 입니다.

입력 : 두개의 정수 N, K(N은 3 이상 1000 이하, K는 1 이상 1000이하)
출력 마지막 살아남는 두 사람의 번호를 오름차순으로 출력
 */
public class quiz1 {
    public static void main (String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int idx = 0;
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < N; i++){
            list.add(i+1);
        }

        for (int i = 0; i < N-2; i++){
            list.remove(idx);
            idx += K-1;
            while (true){
                if (idx > (list.size()-1)) idx -= list.size();
                else break;
            }
        }

        System.out.println(list.get(0) + " " + list.get(1));
    }
}
