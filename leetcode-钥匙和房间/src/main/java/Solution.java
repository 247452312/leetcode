import java.util.ArrayList;
import java.util.List;

/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年08月31日 11时42分
 */
public class Solution {
    /**
     * 每个房间对应的钥匙是否存在
     */
    private byte[] tempKey;
    /**
     * 每个房间是否进入过
     */
    private byte[] tempRooms;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        tempKey = new byte[rooms.size()];
        tempRooms = new byte[rooms.size()];
        // 初始化0号房间
        tempKey[0] = (byte) 1;
        for (int i = 0; i < rooms.size(); i++) {
            intoRoom(i, rooms);
        }
        for (int i = 0; i < tempRooms.length; i++) {
            if (tempRooms[i] == (byte) 0) {
                return false;
            }
        }
        return true;
    }

    public void intoRoom(int roomNumber, List<List<Integer>> roomKeys) {
        // 如果没有进入过
        if (tempRooms[roomNumber] == (byte) 0) {
            // 如果钥匙存在
            if (tempKey[roomNumber] == (byte) 1) {
                // 设置房间已经进入过
                tempRooms[roomNumber] = (byte) 1;
                // 添加钥匙
                for (int i = 0; i < roomKeys.get(roomNumber).size(); i++) {
                    tempKey[roomKeys.get(roomNumber).get(i)] = (byte) 1;
                }
                for (int i = 0; i < roomKeys.get(roomNumber).size(); i++) {
                    intoRoom(roomKeys.get(roomNumber).get(i), roomKeys);
                }


            }
        }
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> rooms = new ArrayList<>();
        ArrayList<Integer> firstRoom = new ArrayList<>();
        firstRoom.add(1);
        rooms.add(firstRoom);
        ArrayList<Integer> twoRoom = new ArrayList<>();
        twoRoom.add(2);
        rooms.add(twoRoom);
        ArrayList<Integer> threeRoom = new ArrayList<>();
        threeRoom.add(3);
        rooms.add(threeRoom);
        ArrayList<Integer> foreRoom = new ArrayList<>();
        rooms.add(foreRoom);
        boolean b = new Solution().canVisitAllRooms(rooms);
        System.out.println(b);
    }
}
