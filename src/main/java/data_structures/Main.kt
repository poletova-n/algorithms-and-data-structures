package data_structures

fun main() {





    val binaryTree1 = NonSortedBinaryTree(6)
    binaryTree1.setLeftChild(5, binaryTree1.getHeadNode())
    binaryTree1.setRightChild(3, binaryTree1.getHeadNode())
    val headLeftChild = binaryTree1.getHeadNode().leftChild
    val headRightChild = binaryTree1.getHeadNode().rightChild
    binaryTree1.setLeftChild(8, headRightChild!!)
    binaryTree1.setRightChild(1, headRightChild)
    binaryTree1.setRightChild(9, headRightChild.leftChild!!)

    println(binaryTree1.searchInWight(8))
    println(binaryTree1.searchInDeep(1, headRightChild))

}

