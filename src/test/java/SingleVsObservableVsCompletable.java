import io.reactivex.Single;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleVsObservableVsCompletable {
    public static void main(String[] args) {
/*        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("c");

        Single.just(list).subscribe();*/

        int[] nums = {7, 10, 10, 15, 15, 15, 15, 10, 10, 10, 15, 10, 10};
        int target = 10;

        int lenCount = 0;
        int maxLen = 0;
        for (int val : nums) {
            if (val == target) {
                lenCount++;
            } else {
                if (lenCount > maxLen) {
                    maxLen = lenCount;
                }
            }
        }
        if (lenCount < maxLen) {
            maxLen = lenCount;
        }
        System.out.println(maxLen);

    }
}
