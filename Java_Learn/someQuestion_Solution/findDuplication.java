//import jdk.nashorn.internal.parser.Scanner;
import java.util.Scanner;
class findDuplication {
    /**
     * Question:给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     * 
     * 快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素，
     * 注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界)，
     * 因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素，
     * 即按照寻找链表环入口的思路来做。
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while(true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) {
                fast = 0;
                while(nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }

    /**
     * 一个常规的方法
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = new int[5];
        Scanner scanIn = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            nums[i] = scanIn.nextInt();    
        }
        //System.out.println(findDuplication.findDuplicate(nums));
        System.out.println(findDuplication.findDuplicate2(nums));
    }
}