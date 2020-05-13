package data_structures

import data_structures.nodes.DequeNode

class Deque<T> (
        var currentElement: DequeNode<T>
) {
    public fun getPreviousElement() = currentElement.previousElement

    public fun getNextElement() = currentElement.previousElement

    public fun setPreviousElement(previousElement: DequeNode<T>) {
        currentElement.previousElement = previousElement
        previousElement.nextElement = currentElement
    }

    public fun setNextElement(nextElement: DequeNode<T>){
        currentElement.nextElement = nextElement
        nextElement.previousElement = currentElement
    }
}
