
class Node<T extends Comparable<T>> {
    T data;
    Node left;
    Node right;

    Node(T data) {
        this.data = data;
    }

    public Node<T> addLeftNode(T data) {
        left = new Node<>(data);
        return left;
    }

    public Node<T> addRightNode(T data) {
        right = new Node<>(data);
        return right;
    }
}

public class PreorderComparison {
    public static boolean preorderCompare(Node first, Node second) {
        if (first == null && second == null) return true;
        if (first == null || second == null) return false;
        if (first.data != second.data) {
            return false;
        }
        return preorderCompare(first.left, second.left) && preorderCompare(first.right, second.right);
    }

    public static boolean looselyCompare(Node first, Node second) {
        if (first == second) return true;
         if (first == null || second == null) return false;

        if (first.data != second.data) {
            return false;
        }

        if (preorderCompare(first.left, second.left) && preorderCompare(first.right, second.right)) return true;

        return looselyCompare(first.left, second.right) && looselyCompare(first.right, second.left);
    }
}
