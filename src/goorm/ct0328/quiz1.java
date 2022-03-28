package goorm.ct0328;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
N * N 배열에서 시작점(0,0)에서 도착점(N-1, N-1) 까지의 최단거리를 구하는 프로그램을 작성하십시오.

배열의 크기와 지나갈 수 있는 길(1)인지 없는 길(0)인지의 여부를 입력하면 최단거리가 출력됩니다.

입력

첫 줄에 N*N 배열의 N (10 이하의 자연수)

다음 N줄 부터 길의 정보 N개를 입력 ( 1일 때는 지나갈 수 있는 길, 0일 때는 지나갈 수 없는 길입니다.)

출력

시작점부터 도착점까지의 최단거리 ( 도착점까지 길이 없을 경우 프로그램 종료)
 */
public class quiz1 {
    public static void main (String[] arg) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] list = new int[N][N];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                list[i][j] = sc.nextInt();
            }
        }

        if (list[0][0] == 0) return;

        RoadSearch(list,N,1,0,0,result);
        if (result.size() == 0) return;
        int output = result.get(0);
        for (int data : result){
            if (data < output) output = data;
        }
        System.out.println(output);
    }

    public static void RoadSearch(int[][] list,int N,int cnt,int x,int y,ArrayList<Integer> result){
        if (x == N-1 && y == N-1) result.add(cnt);
        int[][] new_list = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                new_list[i][j] = list[i][j];
            }
        }
        new_list[x][y] = 0;
        if (y < N-1 && new_list[x][y+1] == 1) RoadSearch(new_list,N,cnt+1,x,y+1,result);
        if (x < N-1 && new_list[x+1][y] == 1) RoadSearch(new_list,N,cnt+1,x+1,y,result);
        if (x > 0 && new_list[x-1][y] == 1) RoadSearch(new_list,N,cnt+1,x-1,y,result);
        if (y > 0 && new_list[x][y-1] == 1) RoadSearch(new_list,N,cnt+1,x,y-1,result);
    }
}
