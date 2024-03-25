import scala.annotation.tailrec

object RLE {

  sealed trait State {
    def nextCharOfTheString(char: Char): State

    def endOfIteration(): State
  }

  final case object Start extends State {
    override def nextCharOfTheString(char: Char): State = Next(char, 1, "")

    override def endOfIteration(): State = End("")
  }

  final case class Next(previousChar: Char, lengthOfChar: Int, result: String) extends State {
    override def nextCharOfTheString(char: Char): State = {
      if (previousChar == char) Next(char, lengthOfChar + 1, result)
      else Next(char, 1, s"$result$previousChar$lengthOfChar")
    }

    override def endOfIteration(): State = {
      End(s"$result$previousChar$lengthOfChar")
    }
  }

  final case class End(result: String) extends State {
    override def nextCharOfTheString(char: Char): State = this

    override def endOfIteration(): State = this
  }

  @tailrec
  def sumMethodeOfLists(inputList: List[Int], result: Int): Int = {
    inputList match {
      case head :: tail => sumMethodeOfLists(tail, result + head)
      case Nil => result
    }
  }


}



