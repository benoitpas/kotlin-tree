import Tree.Node.Branch
import Tree.Node.Leaf

fun main(args: Array<String>) {
    val leaf = Leaf<String>(0)

    fun createNode(v: String) : Tree.Node<String> {
        return Branch(v,leaf,leaf)
    }

    val nb = createNode("b")
    val nd = createNode("d")
    val ne = createNode("e")
    val nc = Branch("c", nd, ne)
    val na = Branch("a",nb,nc)

    println(na)
    println(Tree.addId(na,0))

}