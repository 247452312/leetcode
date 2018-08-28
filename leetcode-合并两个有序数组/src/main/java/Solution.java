import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 12:14
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1, 0, m + n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[100];
        int[] temp = {1, 2, 3, 4};
        for (int i = 0; i < temp.length; i++) {
            nums1[i] = temp[i];
        }
        int m = 4;
        int[] nums2 = {2, 3, 4};
        int n = 3;
        solution.merge(nums1, m, nums2, n);

        for (int i : nums1) {
            System.out.println(i);
        }
    }

    public void batter(int[] nums1, int m, int[] nums2, int n) {
        int pos=0;
        int[] res =  new int[nums1.length];
        int mPos = 0 , nPos = 0;
        while(mPos<m||nPos<n){
            if(mPos<m&&nPos<n){
                if(nums1[mPos]<=nums2[nPos]){
                    res[pos] = nums1[mPos];
                    pos++;
                    mPos++;
                }else{
                    res[pos] = nums2[nPos];
                    pos++;
                    nPos++;
                }
                continue;
            }
            if(mPos==m){
                res[pos]=nums2[nPos];
                pos++;
                nPos++;
                continue;
            }
            if(nPos==n){
                res[pos]=nums1[mPos];
                pos++;
                mPos++;
                continue;
            }
        }

        for(int i=0;i<m+n;i++){
            nums1[i]=res[i];
        }
    }
}
