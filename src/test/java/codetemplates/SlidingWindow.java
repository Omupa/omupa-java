package codetemplates;

public class SlidingWindow {

    public static int fn(int[] arr) {
        int left = 0;
        int ans = 0;
        int curr = 0;

        for (int right = 0; right < arr.length; right++) {
            // do logic here to add arr[right] to curr

            while (Boolean.TRUE.equals(true)) { // Customize condition
                // remove arr[left] from curr
                left++;
            }

            // update ans
            ans = 10;
        }

        return ans;
    }

}
