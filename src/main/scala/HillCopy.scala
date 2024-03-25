import scala.annotation.tailrec

object HillCopy {


  def findLocaleMaxInNumberList(numberList: List[Int]): List[(Int, Int)] = {
    @tailrec
    def helper(previousNumber: Int, actualList: List[Int], actualIndex: Int, result: List[(Int, Int)]): List[(Int, Int)] = {
      actualList match {
        case head :: Nil => if (head > previousNumber) result :+ (actualIndex -> head)
        else result
        case head :: tail => if (head >= previousNumber && head > tail.head) helper(head, tail, actualIndex + 1, result :+ (actualIndex -> head))
        else if (head > previousNumber && head >= tail.head) helper(head, tail, actualIndex + 1, result :+ (actualIndex -> head))
        else helper(head, tail, actualIndex + 1, result)
      }
    }

    numberList match {
      case Nil => Nil
      case head :: tail => if (head > tail.head) helper(head, tail, 1, List(0 -> head))
      else helper(head, tail, 1, Nil)
    }


  }

}
