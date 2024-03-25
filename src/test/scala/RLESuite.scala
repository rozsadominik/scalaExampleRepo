import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import RLE._

class RLESuite extends AnyFlatSpec with should.Matchers {

  "test" should "do it" in {
    val input = "aaaabbbcccddde"
    val otherInput = "abzyyybbbb   dd"
    val End(result) = otherInput.foldLeft[State](Start) { (state, char) => state.nextCharOfTheString(char) }.endOfIteration()
    println(result)
    println(sumMethodeOfLists(List(1, 2, 3, 4, 5, 6), 0))

  }

}
