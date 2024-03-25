import scala.annotation.tailrec

object Hill {

  def findLocaleMax(listOfHill: List[Int]): List[(Int, Int)] = {
    @tailrec
    def helper(previousNumber: Int, index: Int, hill: List[Int], result: List[(Int, Int)]): List[(Int, Int)] = {
      hill match {
        case head :: Nil => if (head > previousNumber) result :+ (index -> head)
        else result
        case head :: tail => if (previousNumber < head && head >= tail.head) helper(head, index + 1, tail, result :+ (index -> head))
        else if (previousNumber == head && head > tail.head) helper(head, index + 1, tail, result :+ (index -> head))
        else helper(head, index + 1, tail, result)

      }
    }

    listOfHill match {
      case Nil => Nil
      case head :: tail => if (head > tail.head) helper(listOfHill.head, 1, listOfHill.tail, List(0 -> head))
      else helper(listOfHill.head, 1, listOfHill.tail, Nil)
    }
  }

}
