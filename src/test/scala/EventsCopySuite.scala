import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import EventsCopy._

class EventsCopySuite extends AnyFlatSpec with should.Matchers {

  "EventsCopy" should "do It" in {
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

    println(findBadAnomaly(events))
  }

}
