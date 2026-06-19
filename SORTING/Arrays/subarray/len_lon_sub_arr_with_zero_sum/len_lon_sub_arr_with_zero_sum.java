import java.util.*;

public class len_lon_sub_arr_with_zero_sum {

    public static int solve(int nums[]) {
        int pref = 0;
        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            pref += nums[i];

            if (map.containsKey(pref)) {
                max = Math.max(max, i - map.get(pref));
            } else {
                map.put(pref, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int nums[] = {9, -3, 3, -1, 6, -5};
        System.out.println(solve(nums));
    }
}