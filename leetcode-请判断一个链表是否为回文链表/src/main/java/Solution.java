import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 10:21
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        boolean palindrome = solution.isPalindrome(listNode);
        System.out.println(palindrome);

    }


    public boolean batter(ListNode head) {
        //     if (p == null) p = head;
        //     if (head == null) return true;
        //     if (!isPalindrome(head.next)) return false;
        //     if (p.val != head.val) return false;
        //     p = p.next;
        //     return true;
        // }
        // public void dfs(ListNode now) {
        //     if (now == null) return;
        //     dfs(now.next);
        //     if (!flag) return;
        //     if (p.val != now.val) flag = false;
        //     else p = p.next;
        // }
        if (head == null || head.next == null) {
            return true;
        }
        if (head.val == head.next.val && head.next.next == null) {
            return true;
        }
        //到这时，链表的长度为3
        ListNode slow = head;
        ListNode cur = head.next;
        while (cur.next != null) {
            if (cur.next.val == slow.val) {
                if (cur.next.next != null) {
                    return false;
                }//避免1011 第三个出现和第一个相同的，但是还有第四个的情况
                cur.next = null;
                slow = slow.next;
                cur = slow.next;
                if (cur == null || slow.val == cur.val) {
                    return true;
                }
            } else {
                cur = cur.next;
            }
        }
        return false;
    }
}
