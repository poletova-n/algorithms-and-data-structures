package data_structures.nodes

data class QueueNode<T>(
      var info: T,
      var nextElement: QueueNode<T>?
)
