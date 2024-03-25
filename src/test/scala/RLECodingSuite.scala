import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import RLECoding._

class RLECodingSuite extends AnyFlatSpec with should.Matchers {

  "RLE" should "works" in {
    val input = "aaabbbcccddddddddd"
    val End(result) = input.foldLeft[State](Start) { (state, char) => state.nextChar(char) }.endOfString()
    println(result)
  }
}
