package ds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author alex
 */
public class BinaryTreeTest {

    BinaryTree<String, Integer> binaryTree;

    @Before
    public void setup() {
        binaryTree = new BinaryTree<>();
    }

    @Test
    public void insertHeadTest() {
        binaryTree.insert("Five", 5);
        Assert.assertTrue("Insert 5. Head should be 5",
                binaryTree.getNode("Five").val == 5);
    }

    @Test
    public void insertSidesTest() {
        binaryTree.insert("5", 5);
        binaryTree.insert("6", 6);
        binaryTree.insert("4", 4);
        Assert.assertTrue("Insert 5. Head should be 5",
                binaryTree.getValue("5") == 5);

        Assert.assertTrue("Insert 6. Right should be 6",
                binaryTree.getNode("5").right.val == 6);

        Assert.assertTrue("Insert 4. Left should be 4",
                binaryTree.getNode("5").left.val == 4);
    }

    @Test
    public void insertLeftSideTest() {
        binaryTree.insert("3", 3);
        binaryTree.insert("2", 2);
        binaryTree.insert("1", 1);

        Assert.assertTrue("Insert 3. Head should be 3",
                binaryTree.getValue("3") == 3);
        Assert.assertTrue("Insert 2. Head->Left should be 2",
                binaryTree.getNode("3").left.val == 2);
        Assert.assertTrue("Insert 1. Head->Left->Left should be 1",
                binaryTree.getNode("3").left.left.val == 1);
    }

    @Test
    public void insertRightSideTest() {
        binaryTree.insert("1", 1);
        binaryTree.insert("2", 2);
        binaryTree.insert("3", 3);

        Assert.assertTrue("Insert 1. Head should be 1",
                binaryTree.getValue("1") == 1);

        Assert.assertTrue("Insert 2. Head->Right should be 2",
                binaryTree.getNode("1").right.val == 2);

        Assert.assertTrue("Insert 1. Head->Left->Left should be 1",
                binaryTree.getNode("1").right.right.val == 3);
    }

    @Test
    public void insertMixedTest() {
        binaryTree.insert("3", 3);
        binaryTree.insert("5", 5);
        binaryTree.insert("2", 2);
        binaryTree.insert("4", 4);
        binaryTree.insert("6", 6);

        Assert.assertTrue("Insert 3. Head should be 3",
                binaryTree.getValue("3") == 3);

        Assert.assertTrue("Insert 5. Head->Right should be 5",
                binaryTree.getNode("3").right.val == 5);

        Assert.assertTrue("Insert 2. Head->Left should be 1",
                binaryTree.getNode("3").left.val == 2);

        Assert.assertTrue("Insert 4. Head->Right->Left should be 6",
                binaryTree.getNode("3").right.left.val == 4);

        Assert.assertTrue("Insert 6. Head->Right->Right should be 6",
                binaryTree.getNode("3").right.right.val == 6);

    }


}
