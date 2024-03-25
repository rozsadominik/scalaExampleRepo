import MostLetter._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MostLetterSuite extends AnyFlatSpec with should.Matchers {

  "Most letter" should "do da work" in {
    val input = "aaabbbcccccccddbb"
    val End(result) = input.foldLeft[State](Start) { (state, char) => state.nextLetter(char) }.endOfIteration()
    println(result)
  }

}
