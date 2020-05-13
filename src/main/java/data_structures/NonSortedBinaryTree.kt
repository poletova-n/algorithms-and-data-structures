package data_structures

import data_structures.nodes.BinaryTreeNode

class NonSortedBinaryTree<T : Comparable<T>>(
        headElement: T
) {

    private var headNode: BinaryTreeNode<T> = BinaryTreeNode(element = headElement, leftChild = null, rightChild = null, parentNode = null)

    fun getHeadNode() = headNode


    fun setLeftChild(leftChild: T, parentNode: BinaryTreeNode<T>) {
        val childNode = BinaryTreeNode(element = leftChild, leftChild = null, rightChild = null, parentNode = parentNode)
        parentNode.leftChild = childNode
    }

    fun setRightChild(rightChild: T, parentNode: BinaryTreeNode<T>) {
        val child = BinaryTreeNode(element = rightChild, leftChild = null, rightChild = null, parentNode = parentNode)
        parentNode.rightChild = child
    }

    //DFS: has modifications - pre-order(+) in-order and post-order
    fun searchInDeep(element: T, node: BinaryTreeNode<T> = headNode): Boolean {
        if (node.element == element) {
            return true
        } else {
            if (node.leftChild != null) {
                return searchInDeep(element, node.leftChild!!)
            }

            if (node.rightChild != null) {
                return searchInDeep(element, node.rightChild!!)
            }
        }
        return false
    }

    // BFS
    fun searchInWight(element: T): Boolean {
        val queue = mutableListOf(headNode)
        while (queue.isNotEmpty()){
            if (queue[0].element == element){
                return true
            }
            if (queue[0].leftChild != null) {
                queue.add(queue[0].leftChild!!)
            }
            if (queue[0].rightChild != null) {
                queue.add(queue[0].rightChild!!)
            }
            queue.removeAt(0)
        }
        return false
    }

}
