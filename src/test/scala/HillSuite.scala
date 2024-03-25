import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import Hill._

class HillSuite extends AnyFlatSpec with should.Matchers {
  "Hill" should "work" in {
    println(findLocaleMax(List(5, 3, 2, 4,4,4,2)))
  }
}
