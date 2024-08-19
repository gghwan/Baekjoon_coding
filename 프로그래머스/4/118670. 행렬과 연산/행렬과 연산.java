import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[][] rc = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String[] operations = {"Rotate", "ShiftRow"};
        System.out.println(Arrays.deepToString(solution(rc, operations)));
    }

    public static int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = new int[rc.length][rc[0].length];

        ArrayDeque<Integer> l = new ArrayDeque<>();
        ArrayDeque<Integer> r = new ArrayDeque<>();
        ArrayDeque<ArrayDeque<Integer>> m = new ArrayDeque<>();

        for (int[] a : rc) {
            ArrayDeque<Integer> x = new ArrayDeque<>();
            for (int j = 0; j < a.length; j++) {
                if (j == 0)
                    l.add(a[j]);
                else if (j == a.length - 1)
                    r.add(a[j]);
                else
                    x.add(a[j]);
            }
            m.add(x);
        }

        for (String operation : operations) {
            if ("ShiftRow".equals(operation)) {
                l.addFirst(l.pollLast());
                m.addFirst(m.pollLast());
                r.addFirst(r.pollLast());
            }
            else {
                m.peekFirst().addFirst(l.pollFirst());
                r.addFirst(m.peekFirst().pollLast());
                m.peekLast().addLast(r.pollLast());
                l.addLast(m.peekLast().pollFirst());
            }
        }

        for (int i = 0; i < rc.length; i++) {
            int j = 0;
            answer[i][j++] = l.pollFirst();
            ArrayDeque<Integer> x = m.pollFirst();
            while (!x.isEmpty()) {
                answer[i][j++] = x.pollFirst();
            }
            answer[i][j] = r.pollFirst();
        }

        return answer;
    }
}