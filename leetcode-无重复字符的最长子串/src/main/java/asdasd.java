import java.util.ArrayList;
import java.util.List;

/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年03月27日 17时27分
 */
public class asdasd {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                    for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                        if (nums[i] + nums[i1] + nums[i2] + nums[i3] == target) {
                            List<Integer> lists = new ArrayList<>();
                            lists.add(nums[i]);
                            lists.add(nums[i1]);
                            lists.add(nums[i2]);
                            lists.add(nums[i3]);
                            list.add(lists);
                        }
                    }
                }
            }

        }
        return list;


    }

    public static void main(String[] args) {

    }
}
