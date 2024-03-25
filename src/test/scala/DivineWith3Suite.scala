import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import DivineWith3._

class DivineWith3Suite extends AnyFlatSpec with should.Matchers {

  "DivineLists" should "work" in {
    println(divineThreeList(List(1, 1, 3, 5, 6)))
  }


}
