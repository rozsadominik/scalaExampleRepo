import WalkingOnTree.{DeadEnd, Goal, Node, walkingOnDangerous}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class WalkingOnTreeSuite extends AnyFlatSpec with should.Matchers {

  "Tree" should "works" in {
    val node =
      Node(
        Node(
          DeadEnd,
          DeadEnd,
          Node(
            DeadEnd,
            DeadEnd,
            DeadEnd)),
        Node(
          Node(
            Node(
              DeadEnd,
              DeadEnd,
              DeadEnd),
            DeadEnd,
            DeadEnd),
          DeadEnd,
          DeadEnd),
        Node(
          Node(
            DeadEnd,
            Node(
              DeadEnd,
              Goal,
              DeadEnd),
            DeadEnd),
          DeadEnd,
          DeadEnd))

    println(walkingOnDangerous(node))


    val vmi: List[Int] = List(1, 2, 3)
    val vmi2: List[List[Int]] = List(1) :: List(2) :: List(3) :: Nil
    val vmi3 = vmi :+ 3
    println(vmi + "\n" + vmi2 + "\n" + vmi3)
    val combine: List[Any] = vmi :+ vmi2
    val combine2: List[Any] = vmi ::: vmi2

    println(combine + "\n" + combine2)
  }
}
