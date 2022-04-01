package goorm.ct0401;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
다익스트라 알고리즘은 가중치가 있는 그래프에서 노드사이의 최단 경로를 찾는 알고리즘 입니다.

동작 과정을 살펴보면 다음과 같습니다.

1. 아직 확인되지 않은 거리는 초기값을 무한으로 설정하여 둔다.

2. 이웃 노드를 방문하여 거리를 계산하며 그래프를 업데이트 시킨다.

3. 더 빠른 경로를 반견하면 값을 새로 업데이트한다.

그래프와 출발점을 입력하고 각 노드들까지의 최단거리를 출력하는 프로그램(다익스트라 알고리즘)을 작성하십시오.

* 이 문제에서 간선은 모두 양방향 간선 입니다.

입력

첫 줄에 정점(N)과 간선(E)의 수를 순서대로 입력

다음 줄 부터 E 줄 동안 간선의 정보를 시작노드, 도착노드, 가중치 순으로 입력

마지막 줄에 시작점 입력

출력

N:V 꼴로 시작점에서 각 정점까지의 최소거리를 표현(입출력 예시 참고)

예시 1
입력
3 4
1 2 5
1 3 4
2 3 2
2 3 1
1
출력
1: 0
2: 5
3: 4

예시 2
입력
4 4
1 2 3
1 3 2
2 1 5
3 4 3
2
출력
1: 3
2: 0
3: 5
4: 8
 */
public class quiz1 {
    public static void main (String[] arg)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        int[] n_list = new int[N];
        int[][] e_list = new int[N][N];
        for (int i = 0; i <  N; i++){
            n_list[i] = i+1;
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (i == j) e_list[i][j] = 0;
                // -1을 무한이라고 가정
                else e_list[i][j] = -1;
            }
        }
        for (int i = 0; i < E; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            // -1 혹은 입력 받은 수가 기존보다 적으면 입력 , 노드는 idx +1 ex) e_list[0][2] = 2 -> 1 3 2
            if (e_list[x-1][y-1] == -1 || e_list[x-1][y-1] > z) {
                e_list[x-1][y-1] = z;
                e_list[y-1][x-1] = z;
            }
        }
        int st = sc.nextInt();
        st -= 1;

        for (int i = 0; i < n_list.length; i++){
            System.out.println(i+1 + ": " +result(st,i,e_list));
        }
    }

    private static int result(int x, int y, int[][] e_list){
        ArrayList<Integer> result_list = new ArrayList<>();
        int result;
        if (x == y) return 0;
        shortRoad(x, y, e_list, result_list,0);
        if (result_list.size() == 0) return -1;
        result = result_list.get(0);
        for (int data : result_list){
            if (result > data) result = data;
        }
        return result;
    }

    // x 출발노드 , y 다음노드 , e_list 가중치 , result_list 최종 노드 도착 거리 , 목표노드, 가중치의 합
    private static void shortRoad(int x, int y, int[][] e_list, ArrayList<Integer> result_list, int cnt){
        int length = e_list.length;
        int[][] new_list = new int[length][length];
        if (e_list[x][y] == -1) return;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; j++){
                new_list[i][j] = e_list[i][j];
            }
        }
        for (int i = 0; i < length; i++){
            if (x == y) {
                result_list.add(cnt);
            }else if(i != x){
                cnt += new_list[x][i];
                new_list[x][i] = -1;
                new_list[i][x] = -1;
                shortRoad(i,y,new_list,result_list,cnt);
            }
        }
    }
}
