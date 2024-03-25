object RLECoding {

  //aaabbbdddeee =>a3b3d3e3
  //""=>""

  sealed trait State {
    def nextChar(char: Char): State

    def endOfString(): State
  }

  final case object Start extends State {
    override def nextChar(char: Char): State = IterateOnString(char, 1, "")

    override def endOfString(): State = End("")
  }

  final case class IterateOnString(previousChar: Char, length: Int, result: String) extends State {
    override def nextChar(actualChar: Char): State = {
      if (previousChar == actualChar) IterateOnString(actualChar, length + 1, result)
      else IterateOnString(actualChar, 1, s"$result$previousChar$length")
    }

    override def endOfString(): State = End(s"$result$previousChar$length")
  }

  final case class End(result: String) extends State {
    override def nextChar(char: Char): State = this

    override def endOfString(): State = this
  }

}
