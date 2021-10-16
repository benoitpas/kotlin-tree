import Tree.Node.Leaf

class Tree<T> {

    sealed class Node<T> {
        data class Leaf<T>(val dummy: Int) : Node<T>() // Cannot use object there because of generic
        // and dataclass has to have a value

        data class Branch<T>(
            val v: T,
            val left: Node<T>,
            val right: Node<T>
        ) : Node<T>()
    }

    private val leaf = Leaf<T>(0);

    fun <T> addId(tree: Tree<T>): Node<Pair<T, Int>> {

        return Leaf(0);
    }
}
