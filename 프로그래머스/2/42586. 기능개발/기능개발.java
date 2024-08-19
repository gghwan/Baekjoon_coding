import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if (remain % speeds[i] > 0)
                day++;

            int work = 1;
            while (i + 1 < progresses.length
                    && progresses[i + 1] + speeds[i + 1] * day >= 100) {
                i++;
                work++;
            }
            answer.add(work);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}