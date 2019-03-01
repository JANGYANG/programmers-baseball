package bfds.baseball;

import java.util.Arrays;

class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;
        for(int i = 1; i < 10; i++){
            for(int j = 1; j < 10; j++ ){
                for(int k = 1; k < 10; k++){
                    if( i == j || i == k || j == k) continue;
                    String tmp = new StringBuffer().append(i).append(j).append(k).toString();

                    answer += baseball(baseball, tmp);
                }
            }
        }
        return answer;
    }
    public int baseball(int[][] baseball, String num){
        for(int[] score : baseball){
            if(!Arrays.equals(Arrays.copyOfRange(score, 1, 3), score(String.valueOf(score[0]),num))){
                return 0;
            }
        }
        return 1;
    }
    public int[] score(String ans, String que){
        int[] result = {0,0};
        for(String s : que.split("")){
            if(ans.contains(s)){
                result[1]++;
            }
            if(ans.substring(que.indexOf(s), que.indexOf(s)+1).equals(s)){
                result[0]++;
                result[1]--;
            }
        }
        return result;
    }
}