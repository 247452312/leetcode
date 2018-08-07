import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-02 14:01
 */
public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);

            for (int i = 0; i < split[1].length(); i++) {
                if (split[1].charAt(i) == '.') {
                    String key = split[1].substring(i + 1);
                    map.put(key, map.getOrDefault(key, 0) + count);
                }
            }
            map.put(split[1], map.getOrDefault(split[1], 0) + count);
        }

        List<String> list = new ArrayList<String>();
        for (String s : map.keySet()) {
            sb.delete(0, sb.length());
            sb.append(map.get(s));
            sb.append(" ");
            sb.append(s);
            list.add(sb.toString());
        }


        return list;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.subdomainVisits(new String[]{"9000 www.baidu.com", "100 www.4399.com"});

        for (String string : strings) {
            System.out.println(string);
        }
    }

}
