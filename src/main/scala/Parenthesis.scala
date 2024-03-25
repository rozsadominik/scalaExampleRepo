object Parenthesis {

  def createParenthesis(numberOfBrackets: Int): List[String] = {
    def helper(number: Int, result: String): List[String] = {
      if (result.length == numberOfBrackets) List(result)
      else helper(number, "()" + result) ::: helper(number, "(" + result + ")") ::: helper(number, result + "()")

    }

    if (numberOfBrackets % 2 != 0) "Add correct number" :: Nil
    else helper(numberOfBrackets, "()").distinct
  }

}
