package data_structures

import data_structures.nodes.BinaryTreeNode

class InitiallySortedBinaryTree<T : Comparable<T>>(
        headElement: T
) {
    private var headNode: BinaryTreeNode<T> = BinaryTreeNode(element = headElement, leftChild = null, rightChild = null, parentNode = null)

    private fun setLeftChild(leftChild: T, parentNode: BinaryTreeNode<T>) {
        val childNode = BinaryTreeNode(element = leftChild, leftChild = null, rightChild = null, parentNode = parentNode)
        parentNode.leftChild = childNode
    }

    private fun setRightChild(rightChild: T, parentNode: BinaryTreeNode<T>) {
        val child = BinaryTreeNode(element = rightChild, leftChild = null, rightChild = null, parentNode = parentNode)
        parentNode.rightChild = child
    }

    fun addElement(element: T) {
        var currentNode = headNode

        var foundPlace = false

        while (!foundPlace) {
            if (currentNode.element.compareTo(element) == -1) {
                if (currentNode.leftChild == null) {
                    foundPlace = true
                    setLeftChild(element, currentNode)
                } else {
                    currentNode = currentNode.leftChild!!
                }
            } else {
                if (currentNode.rightChild == null) {
                    foundPlace = true
                    setRightChild(element, currentNode)
                } else {
                    currentNode = currentNode.rightChild!!
                }
            }
        }
    }

    fun findElement(element: T): Boolean {
        var curr = headNode

        while (true) {
            if (curr.element.compareTo(element) == 0) {
                return true
            } else {
                curr = if (curr.element.compareTo(element) == -1) {
                    if (curr.leftChild != null){
                        curr.leftChild!!
                    } else {
                        return false
                    }
                } else {
                    if (curr.rightChild != null){
                        curr.rightChild!!
                    } else {
                        return false
                    }
                }
            }
        }
    }
}
