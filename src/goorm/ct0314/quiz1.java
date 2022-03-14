package goorm.ct0314;

import java.util.Scanner;

/*
n*n 크기의 달팽이 배열을 출력하시오.
 */
public class quiz1 {
    public static void main (String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[][] list = new int[input][input];

        for (int x = 0; x < input; x++){
            if(x%4 == 0){
                for (int j = x/2; j < input-x/2; j++){
                    if (x != 0 && j == x/2) list[x/2][j-1] = 1;
                    list[x/2][j] = 1;
                }
            }
            else if(x%4 == 1){
                for (int i = x/2+1; i < input-x/2; i++){
                    list[i][input-x/2-1] = 1;
                }
            }
            else if(x%4 == 2){
                for (int j = x/4*2; j < input-x/2; j++){
                    list[input-x/2][j] = 1;
                }
            }
            else{
                for (int i = x/4*2+2; i < input-x/2; i++){
                    list[i][x/2-1] = 1;
                }
            }
        }

        for (int i = 0; i < input; i++){
            for (int j = 0; j < input; j++){
                if (list[i][j] == 1) System.out.print("# ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
