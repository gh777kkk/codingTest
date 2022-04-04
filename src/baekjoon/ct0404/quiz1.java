package baekjoon.ct0404;


import java.util.Scanner;

/*
피보나치 수열
 */
public class quiz1 {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(pibo(n));
    }

    public static int pibo(int n){
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        return pibo(n-1) + pibo(n-2);
    }
}
