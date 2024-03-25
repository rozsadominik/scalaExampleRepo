import scala.annotation.tailrec

object WalkingOnTree {

  sealed trait Tree

  final case object Goal extends Tree

  final case object DeadEnd extends Tree

  final case class Node(left: Tree, forward: Tree, right: Tree) extends Tree

  def walkingOnDangerous(tree: Tree): List[String] = {
    def helper(actualNode: Tree, result: List[String]): List[String] = {
      actualNode match {
        case DeadEnd => Nil
        case Goal => result :+ " Found it!"
        case Node(left, forward, right) => helper(left, result :+ " left") ::: helper(forward, result :+ " forward") ::: helper(right, result :+ " right")
      }
    }

    helper(tree, Nil)
  }

  @tailrec
  def sumOfInts(numbers: List[Int], result: Int): Int = {
    numbers match {
      case head :: tail => sumOfInts(tail, result + head)
      case Nil => result
    }
  }

}
