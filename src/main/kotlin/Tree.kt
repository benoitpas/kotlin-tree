import Tree.Node.*

object Tree {

    sealed class Node<T> {
        data class Leaf<T>(val dummy: Int) : Node<T>() // Cannot use object there because of generic
        // and dataclass has to have a value

        data class Branch<T>(
            val v: T,
            val left: Node<T>,
            val right: Node<T>
        ) : Node<T>()
    }

    fun <T> addId(tree: Node<T>, index: Int): Pair<Node<Pair<T, Int>>,Int> {
        return when (tree) {
            is Leaf -> Pair(Leaf<Pair<T, Int>>(0), index)
            is Branch -> {
                val newLeft = addId<T>(tree.left, index)
                val newValue = Pair(tree.v, newLeft.second)
                val newRight = addId(tree.right, newLeft.second+1)
                Pair(Branch(newValue, newLeft.first, newRight.first), newRight.second)
            }
        }
    }
}
