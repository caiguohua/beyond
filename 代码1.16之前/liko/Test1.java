package liko;

public class Test1 {
    public void twoSum(int[] nums, int target) {
        int a, b;
        int i, j;
        a = nums[0];
        b = nums[1];
        for (i = 0; i < nums.length; i++) {
            for (j = i+1; j < nums.length; j++) {
                if(target == nums[i]+nums[j] && i!=j ){
                    System.out.println("["+i+","+j+"]");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums ={1,2,4,5,7,8};
        int target = 10;
        Test1 test1 = new Test1();
        test1.twoSum(nums,target);
    }
}

