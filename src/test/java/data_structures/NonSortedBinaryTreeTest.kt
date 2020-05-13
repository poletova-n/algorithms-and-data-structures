package data_structures

import org.junit.Before
import org.junit.Test

class NonSortedBinaryTreeTest {
    lateinit var binaryTree: NonSortedBinaryTree<Int>

    @Before
    fun setup() {
        binaryTree = NonSortedBinaryTree(3)
        binaryTree.setLeftChild(5, binaryTree.getHeadNode())
        binaryTree.setRightChild(13, binaryTree.getHeadNode())
        val headRightChild = binaryTree.getHeadNode().rightChild
        binaryTree.setLeftChild(8, headRightChild!!)
        binaryTree.setRightChild(1, headRightChild)
        binaryTree.setRightChild(9, headRightChild.leftChild!!)
    }

    @Test
    fun shouldReturnTrueIfElementExistsDFS() {
        val result = binaryTree.searchInDeep(1)
        assert(result)
    }

    @Test
    fun shouldReturnFalseIfElementDoesNotExistDFS() {
        val result = binaryTree.searchInDeep(11)
        assert(!result)
    }

    @Test
    fun shouldReturnTrueIfElementExistsBFS() {
        val result = binaryTree.searchInWight(1)
        assert(result)
    }

    @Test
    fun shouldReturnFalseIfElementDoesNotExistBFS() {
        val result = binaryTree.searchInWight(11)
        assert(!result)
    }
}
