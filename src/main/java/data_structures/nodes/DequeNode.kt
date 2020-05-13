package data_structures.nodes

data class DequeNode<T>(
        var info: T,
        var previousElement: DequeNode<T>?,
        var nextElement: DequeNode<T>?
)

