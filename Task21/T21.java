package Task21;

public class T21 {
	public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++; 
                nums[i] = nums[j]; 
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expectedNums = {0, 1, 2, 3, 4};

        int k = removeDuplicates(nums);

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
        
        for(int i : nums) {
        	System.out.print(i + "\n");
        }
        
        // The first fourth numbers are unique
        System.out.println("All tests has been passed!");
    }
}
