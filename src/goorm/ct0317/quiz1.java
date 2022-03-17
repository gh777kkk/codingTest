package goorm.ct0317;

import java.util.Scanner;

/*
최대 자리곱

어떤 수의 자리곱은 각 자리의 수를 곱함으로써 얻을 수 있다. 예를 들어, 37의
자리곱은 3 * 7 = 21, 2102의 자리곱은 1 * 0 * 2 = 0, 8의 자리곱은 8이다.
이때, 1부터 n까지의 정수 중 가장 작은 자리곱을 찾는 것은 쉽다. n이 10
이상이라면 최소 자리곱은 항상0이고, 10 미만이라면 1이기 때문이다. 하지만
가장 큰 자리곱을 찾는 것은 쉽지 않다. n이 주어지면 1부터 n까지의 정수 중에
가장 큰 자리곱의 값을 구해보자

입력
첫째 줄에 정수 n이 주어진다. (단, 1 <= n <= 2 * Math.pow(10,9) )

출력
1부터 n까지의 정수 중 가장 큰 자리곱의 값을 출력한다.
 */
public class quiz1 {
    public static void main (String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int output = mul(input);
        System.out.println(output);
    }

    private static int mul(int input) {
        int length = (int)Math.log10(input)+1;
        int temp = input;
        int result = 1;
        int result_temp = 1;

        if (length == 1) return input;
        if (input/(int)Math.pow(10,length-1) == 1) return (int)Math.pow(9,length-1);

        for (int i = 0; i < length; i++){
            temp = input;
            result_temp = 1;
            for (int j = 1; j <= length; j++){
                if(i >= j) result_temp *= 9;
                else if(j != 1 && i+1 == j) result_temp *= temp%10-1;
                else result_temp *= temp%10;
                temp /= 10;
            }
            if (result_temp > result) result = result_temp;
        }

        return result;
    }
}
