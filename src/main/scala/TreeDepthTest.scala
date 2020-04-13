object TreeDepthTest extends App {
  val myTree = Branch(Branch(Leaf(1), Branch(Leaf(1), Leaf(1))), Leaf(1))
  println(Tree.depth(myTree))
}



sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]


object Tree {

  def depth[A](t: Tree[A]): Int = t match {
    case Leaf(x) => 1
    case Branch(left, right) => 1 + (depth(left) max depth(right))
  }

}