package data_structures

import org.junit.Before
import org.junit.Test

class InitiallySortedBinaryTreeTest {

    lateinit var binaryTree: InitiallySortedBinaryTree<Int>

    @Before
    fun setup() {
        binaryTree = InitiallySortedBinaryTree(3)
        binaryTree.addElement(5)
        binaryTree.addElement(2)
        binaryTree.addElement(4)
    }

    @Test
    fun shouldReturnTrueIfElementExists() {
        val result = binaryTree.findElement(2)
        assert(result)
    }

    @Test
    fun shouldReturnFalseIfElementDoesNotExist() {
        val result = binaryTree.findElement(1)
        assert(!result)
    }
}
