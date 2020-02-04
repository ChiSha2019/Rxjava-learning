import java.util.ArrayList;
import java.util.Arrays;

public class DummyClass {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(0,0,4,2,5,0,3,0));
        int k = 0;
        Integer zero = new Integer(0);
        while (k < nums.size())
        {
            if (nums.get(k).equals(0))
                nums.remove(k);
            k++;
        }
        System.out.println(nums);
    }
}
