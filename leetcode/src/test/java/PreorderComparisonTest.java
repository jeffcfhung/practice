import org.junit.Test;

import static org.junit.Assert.*;

public class PreorderComparisonTest {
    @Test
    public void preorderCompareExpectsSameTrees() {
        /*
                1
               / \
              2   4
             / \
            3   5
         */

        Node<Integer> first = new Node<>(1),
                n2 = first.addLeftNode(2);
        n2.addLeftNode(3);
        n2.addRightNode(5);
        first.addRightNode(4);

        /*
                1
               / \
              2   4
             / \
            3   5
         */

        Node<Integer> second = new Node<>(1),
                m2 = second.addLeftNode(2);

        m2.addLeftNode(3);
        m2.addRightNode(5);
        second.addRightNode(4);

        assertEquals(PreorderComparison.preorderCompare(first, second), true);
    }
    @Test
    public void preorderCompareExpectsDifferentTrees() {
        /*
                1
               / \
              2   4
             / \
            3   5
         */

        Node<Integer> first = new Node<>(1),
                n2 = first.addLeftNode(2);
        n2.addLeftNode(3);
        n2.addRightNode(5);
        first.addRightNode(4);

        /*
                1
               / \
              2   5
             / \
            3   4
         */

        Node<Integer> second = new Node<>(1),
                m2 = second.addLeftNode(2);

        m2.addLeftNode(3);
        m2.addRightNode(4);
        second.addRightNode(5);

        assertEquals(PreorderComparison.preorderCompare(first, second), false);
    }
    @Test
    public void looselyCompareExpectsSameTrees() {
        /*
                1
               / \
              2   4
             / \
            3   5
         */

        Node<Integer> first = new Node<>(1),
                n2 = first.addLeftNode(2);
        n2.addLeftNode(3);
        n2.addRightNode(5);
        first.addRightNode(4);

        /*
                1
               / \
              4   2
                 / \
                5   3
         */

        Node<Integer> second = new Node<>(1),
                m2 = second.addRightNode(2);

        m2.addLeftNode(5);
        m2.addRightNode(3);
        second.addLeftNode(4);

        assertEquals(PreorderComparison.looselyCompare(first, second), true);
    }
}