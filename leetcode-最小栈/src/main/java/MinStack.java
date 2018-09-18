import java.util.*;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 15:53
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    // index --- value
    HashMap<Integer, Integer> list = new HashMap<>();
    //value -- index
    TreeMap<Integer, Integer> map = new TreeMap<>();
    int count = 0;

    public MinStack() {

    }

    public void push(int x) {
        list.put(count, x);
        map.put(x, count);
        count++;
    }

    public void pop() {
        list.remove(new Integer(count-1));
        count--;
        map.clear();
        for (Integer integer : list.keySet()) {
            map.put(list.get(integer), integer);
        }
    }

    public int top() {
        return list.get(new Integer(count-1));
    }

    public int getMin() {
        Integer integer = map.get(map.firstKey());
        return list.get(integer);
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        int top = minStack.top();
        System.out.println(top);
        int min1 = minStack.getMin();
        System.out.println(min1);
    }
}
