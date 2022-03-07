package goorm.ct0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
소수 판별
입력된 수가 소수인지를 판별하는 프로그램을 작성하십시오.
 */
public class quiz1 {
    public static void main (String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int x = Integer.parseInt(input);
        int cnt = 0;
        String result = "False";

        for(int i = 2; i<=(x/2); ++i){
            if (cnt >= 1) break;
            if(x%i == 0) cnt++;
        }
        if(cnt == 0) result = "True";
        System.out.println(result);
        br.close();
    }
}
