import java.util.*;

public class KeysAndRooms {
    private Set<Integer> visited = new HashSet<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visitRoom(rooms, 0);
        return visited.size() == rooms.size();
    }

    private void visitRoom(List<List<Integer>> rooms, int curr) {
        List<Integer> keys = rooms.get(curr);
        visited.add(curr);

        for (Integer key: keys) {
            if (visited.contains(key)) {
                continue;
            }
            visitRoom(rooms, key);
        }
    }
}
