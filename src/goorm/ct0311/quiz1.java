package goorm.ct0311;

import java.util.Scanner;

/*
삼각형의 세 변의 길이가 주어졌을 때 이를 이용하여 삼각형의 넓이를 출력하는 프로그램을 작성하십시오.

입력
세 변의 길이가 공백으로 구분되어 입력 (한 변의 최대 길이 100)

출력
삼각형의 넓이 (소수점 두번째 자리까지)
 */
public class quiz1 {
    public static void main (String[] arg) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[3];
        double sum = 0;
        double result = 0;

        for (int i = 0; i < 3; i++){
            input[i] = scanner.nextInt();
            sum += input[i];
        }

        sum = sum/2;
        result = Math.sqrt(sum * (sum-input[0]) * (sum-input[1]) * (sum-input[2]));
        System.out.printf("%.2f",result);
        scanner.close();
    }
}
