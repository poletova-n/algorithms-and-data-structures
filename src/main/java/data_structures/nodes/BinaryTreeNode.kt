package data_structures.nodes


data class BinaryTreeNode<T : Comparable<T>> (
        var element: T,
        var rightChild: BinaryTreeNode<T>?,
        var leftChild: BinaryTreeNode<T>?,
        var parentNode: BinaryTreeNode<T>?
)

