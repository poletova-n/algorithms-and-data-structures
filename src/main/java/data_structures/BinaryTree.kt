package data_structures

import data_structures.nodes.BinaryTreeNode

class BinaryTree<T : Comparable<T>>(
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

    //has modifications - pre-order(+) in-order and post-order
    fun walkInDeep(element: T, node: BinaryTreeNode<T>? = headNode): Boolean {

        return when {
            node == null -> {
                false
            }
            node.element == element -> {
                true
            }
            else -> {
                walkInDeep(element, node.leftChild) ||
                        walkInDeep(element, node.rightChild)
            }
        }
    }

    // BFS
    // TODO: replace java list with Queue class
    fun searchInWight(element: T): Boolean {
        val queue = mutableListOf(headNode)
        while (queue.isNotEmpty()) {
            if (queue[0].element == element) {
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
