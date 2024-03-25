object MostLetter {


  sealed trait State {
    def nextLetter(char: Char): State

    def endOfIteration(): State
  }

  final case object Start extends State {
    override def nextLetter(char: Char): State = NextIteration(char, 1, 1, "")

    override def endOfIteration(): State = End("")
  }

  final case class NextIteration(prevLetter: Char, numberOfLetter: Int, maxNumber: Int, result: String) extends State {
    override def nextLetter(actualLetter: Char): State = {
      if (prevLetter.equals(actualLetter)) NextIteration(actualLetter, numberOfLetter + 1, maxNumber, result)
      else if (numberOfLetter >= maxNumber) NextIteration(actualLetter, 1, numberOfLetter, s"$prevLetter$numberOfLetter")
      else NextIteration(actualLetter, 1, maxNumber, result)
    }

    override def endOfIteration(): State = {
      if (numberOfLetter >= maxNumber) End(s"$prevLetter$numberOfLetter")
      else End(result)
    }
  }

  final case class End(result: String) extends State {
    override def nextLetter(char: Char): State = this

    override def endOfIteration(): State = this
  }

}
