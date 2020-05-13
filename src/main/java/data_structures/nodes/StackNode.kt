package data_structures.nodes

data class StackNode<T>(
        var info: T,
        var previousElement: StackNode<T>?
)
