package goorm.ct0323;

import java.io.*;
import java.util.*;

/*

 */
public class quiz1 {
    public static void main (String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int input_num = Integer.parseInt(input);
        ArrayList<Integer> list_temp = new ArrayList<>();
        ArrayList<Integer> list_result = new ArrayList<>();

        for (int i = 1; i <= input_num; i++){
            if (i == 1) list_result.add(i);
            else list_temp.add(i);
        }
        for_list(list_temp,list_result);
    }

    public static boolean prime_number(int n, int m){
        int num = n + m;
        for (int i = 2; i <= num/2; i++){
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void for_list(ArrayList<Integer> list_temp,ArrayList<Integer> list_result){
        ArrayList<Integer> temp_new = new ArrayList<>(list_temp);
        ArrayList<Integer> result_new = new ArrayList<>(list_result);
        if(temp_new.size() == 0) {
            System.out.println(list_result);
            return;
        }
        for (int i = 0; i < list_temp.size(); i++){
//            System.out.println(temp_new.size());
//            System.out.println(prime_number(result_new.get(result_new.size()-1),list_temp.get(i)));
//            System.out.println(temp_new);
//            System.out.println(result_new);
//            System.out.println(i);
//            System.out.println("----------------------------------");
//            if (prime_number(result_new.get(result_new.size()-1),list_temp.get(i))) {
//                result_new.add(temp_new.get(i));
//                temp_new.remove(i);
//                for_list(temp_new,result_new);
//            }
            result_new.add(temp_new.get(i));
            temp_new.remove(i);
            for_list(temp_new,result_new);
            result_new = list_result;
            temp_new = list_temp;
        }
    }
}
