import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import Events._
import WalkingOnTree._

class EventSuite extends AnyFlatSpec with should.Matchers {

  "Event" should "works" in {
    val events: List[Event] = List(
      Event(Entry, "bob"),
      Event(Exit, "bob"),
      Event(Entry, "john"),
      Event(Entry, "bob"),
      Event(Exit, "john"),
      Event(Entry, "susan"),
      Event(Entry, "susan"),
      Event(Exit, "ron"),
    )
    println(findAnomaly(events) shouldBe List("bob", "susan", "ron"))
    println(sumOfInts(List(1, 2, 3, 4, 5, 6), 0))
  }
}
