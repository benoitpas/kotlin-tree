import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import Tree.Node.*

object TreeTest {
    private val leaf = Leaf<String>(0)

    private fun createNode(v: String) : Tree.Node<String> {
        return Branch(v,leaf,leaf)
    }
    val nb = createNode("b")
    val nd = createNode("d")
    val ne = createNode("e")
    val nc = Branch("c", nd, ne)
    val na = Branch("a", nb, nc)

    @Test
    fun addId() {
        val leaf = Leaf<Pair<String, Int>>(0)
        fun createNode(v: String, i:Int) : Tree.Node<Pair<String,Int>> {
            return Branch(Pair(v,i) ,leaf,leaf)
        }
        val nbe = createNode("b",0)
        val nde = createNode("d",2)
        val nee = createNode("e",4)
        val nce = Branch(Pair("c",3), nde, nee)
        val nae = Branch(Pair("a",1), nbe, nce)
        Assertions.assertEquals(nae, Tree.addId(na,0).first)
    }
}