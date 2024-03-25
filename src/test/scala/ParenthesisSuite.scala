import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import Parenthesis._

class ParenthesisSuite extends AnyFlatSpec with should.Matchers {

  "Parenthesis" should "work" in {
    println(createParenthesis(6))
  }
}
