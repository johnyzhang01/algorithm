package week01;

/**
 * @Auther: johny
 * @Date: 2019-12-15 00:46
 * @Description:
 */
public class Lc026 {

  public int removeDuplicates(int[] nums) {
    if(nums.length == 0){
      return 0;
    }

    int i = 0;
    for(int j=1;j<nums.length;j++){
      if(nums[i] != nums[j]){
        i++;
        nums[i] = nums[j];
      }

    }
    return i+1;
  }

}
