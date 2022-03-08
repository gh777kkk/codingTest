package programmers.ct0308;

/*
고고학자인 "튜브"는 고대 유적지에서 보물과 유적이 가득할 것으로 추정되는 비밀의 문을 발견하였습니다. 그런데 문을 열려고 살펴보니 특이한 형태의 자물쇠로 잠겨 있었고 문 앞에는 특이한 형태의 열쇠와 함께 자물쇠를 푸는 방법에 대해 다음과 같이 설명해 주는 종이가 발견되었습니다.

잠겨있는 자물쇠는 격자 한 칸의 크기가 1 x 1인 N x N 크기의 정사각 격자 형태이고 특이한 모양의 열쇠는 M x M 크기인 정사각 격자 형태로 되어 있습니다.

자물쇠에는 홈이 파여 있고 열쇠 또한 홈과 돌기 부분이 있습니다. 열쇠는 회전과 이동이 가능하며 열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 자물쇠가 열리게 되는 구조입니다. 자물쇠 영역을 벗어난 부분에 있는 열쇠의 홈과 돌기는 자물쇠를 여는 데 영향을 주지 않지만, 자물쇠 영역 내에서는 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 하며 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안됩니다. 또한 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 자물쇠를 열 수 있습니다.

열쇠를 나타내는 2차원 배열 key와 자물쇠를 나타내는 2차원 배열 lock이 매개변수로 주어질 때, 열쇠로 자물쇠를 열수 있으면 true를, 열 수 없으면 false를 return 하도록 solution 함수를 완성해주세요.

제한사항
key는 M x M(3 ≤ M ≤ 20, M은 자연수)크기 2차원 배열입니다.
lock은 N x N(3 ≤ N ≤ 20, N은 자연수)크기 2차원 배열입니다.
M은 항상 N 이하입니다.
key와 lock의 원소는 0 또는 1로 이루어져 있습니다.
0은 홈 부분, 1은 돌기 부분을 나타냅니다.
입출력 예
key	lock	                        result
[[0, 0, 0], [1, 0, 0], [0, 1, 1]]	[[1, 1, 1], [1, 1, 0], [1, 0, 1]]	true
 */
public class quiz1 {
    public static void main(String[] arg){
        int[][]key = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int[][]lock = {{0, 1, 0 , 1}, {1, 0, 0 , 1}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(quiz1.solution(key,lock));
    }

    private static boolean solution(int[][] key, int[][] lock) {
        int keyLength = key.length;
        int lockLength = lock.length;
        int[][] temp;
        int[][] tempS;
        int cnt = 0;

        for (int i = 0; i < lockLength; i++){
            for (int j = 0; j < lockLength; j++){
                if (lock[i][j] == 0) cnt += 1;
            }
        }
        if (cnt == 0) return true;

        for (int i = 0; i < 4; i++){
            if (i != 0) key = list90(key);
            temp = listValue(key);

            if (result(key,lock)) return true;

            for (int j = 0; j < keyLength; j++){
                if (j != 0){
                    temp = keyUp(temp);
                    if (result(temp,lock)) return true;
                }

                tempS = listValue(temp);

                for (int x = 0; x < lockLength-1; x++){
                    tempS = keyRight(tempS);
                    if (result(tempS,lock)) return true;
                }

                tempS = listValue(temp);

                for (int y = 0; y < keyLength-1; y++){
                    tempS = keyLeft(tempS);
                    if (result(tempS,lock)) return true;
                }
            }

            temp = listValue(key);

            for (int j = 0; j < lockLength; j++){
                if (j != 0){
                    temp = keyDown(temp);
                    if (result(temp,lock)) return true;
                }

                tempS = listValue(temp);

                for (int x = 0; x < lockLength-1; x++){
                    tempS = keyRight(tempS);
                    if (result(tempS,lock)) return true;
                }

                tempS = listValue(temp);

                for (int y = 0; y < keyLength-1; y++){
                    tempS = keyLeft(tempS);
                    if (result(tempS,lock)) return true;
                }
            }
        }

        return false;
    }

    private static int[][] list90(int[][] key) {
        int keyLength = key.length;
        int[][] key90 = new int[keyLength][keyLength];

        for(int i = 0; i < keyLength; i++){
            for(int j = 0; j < keyLength; j++){
                key90[i][j] = key[keyLength-j-1][i];
            }
        }

        return key90;
    }

    private static boolean result(int[][] key, int[][] lock){
        int[][] list = plus(key,lock);
        int listLength = list.length;

        for(int i = 0; i < listLength; i++){
            for(int j = 0; j < listLength; j++){
                if(list[i][j] != 1) return false;
            }
        }

        return true;
    }

    private static int[][] plus(int[][] key, int[][] lock){
        int lockLength = lock.length;
        int keyLength = key.length;
        int[][] result = new int[lockLength][lockLength];

        for (int i = 0; i < lockLength; i++){
            for (int j = 0; j < lockLength; j++){
                if (i >= keyLength || j >= keyLength){
                    result[i][j] = lock[i][j];
                } else result[i][j] = key[i][j] ^ lock[i][j];
            }
        }

        return result;
    }

    private static int[][] keyUp(int[][] key){
        int keyLength = key.length+1;
        int[][] result = new int[keyLength][keyLength];

        for (int i = 0; i < keyLength; i++){
            for (int j = 0; j < keyLength; j++){
                if(i == keyLength - 1 || i == keyLength-2
                        || j == keyLength-1) result[i][j] = 0;
                else result[i][j] = key[i+1][j];
            }
        }
        return result;
    }

    private static int[][] keyDown(int[][] key){
        int keyLength = key.length+1;
        int[][] result = new int[keyLength][keyLength];

        for (int i = 0; i < keyLength; i++){
            for (int j = 0; j < keyLength; j++){
                if(i == 0 || j == keyLength -1) result[i][j] = 0;
                else result[i][j] = key[i-1][j];
            }
        }
        return result;
    }

    private static int[][] keyRight(int[][] key){
        int keyLength = key.length+1;
        int[][] result = new int[keyLength][keyLength];

        for (int i = 0; i < keyLength; i++){
            for (int j = 0; j < keyLength; j++){
                if(j == 0||i == keyLength - 1) result[i][j] = 0;
                else result[i][j] = key[i][j-1];
            }
        }
        return result;
    }

    private static int[][] keyLeft(int[][] key){
        int keyLength = key.length+1;
        int[][] result = new int[keyLength][keyLength];

        for (int i = 0; i < keyLength; i++){
            for (int j = 0; j < keyLength; j++){
                if(j == (keyLength - 1)||i == keyLength - 1
                        || j == keyLength-2) result[i][j] = 0;
                else result[i][j] = key[i][j+1];
            }
        }
        return result;
    }

    private static int[][] listValue(int[][] list) {
        int listLength = list.length;
        int[][] newList = new int[listLength][listLength];

        for (int i = 0; i < listLength; i++){
            for (int j = 0; j < listLength; j++){
                newList[i][j] = list[i][j];
            }
        }
        return newList;
    }
}
