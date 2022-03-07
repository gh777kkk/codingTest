package goorm.ct0307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
데이터를 N진법으로 표현했을 때 어떤 수의 제곱이 되는 최소값 N
 */
public class quiz2 {
    public static void main (String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int x = Integer.parseInt(input);
        int temp = x;
        int ten = 0;
        int min = 0;

        int length = (int)(Math.log10(x)+1);
        for(int i = 0; i < length; i++){
            if(temp%(10)>min) min = temp%(10);
            temp = temp/10;
        }
        min++;
        temp = x;

//        Loop : while(true){
        while(true){
            for(int i = 0; i < length; i++){
                if(temp%(10)>min) min = temp%(10);
                int tenTemp = (temp%(10))*(int)(Math.pow(min,i));
                ten += tenTemp;
                temp = temp/10;
            }
            if ((Math.sqrt(ten) - (int)(Math.sqrt(ten)) == 0)) break ;

//            for(int j = 1; j*j <= ten ; j++){
//                if( (j*j) == ten ) break Loop;
//            }

            ++min;
            temp = x;
            ten = 0;
        }

        System.out.println(min);
        br.close();
    }
}
