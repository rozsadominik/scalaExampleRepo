object EventsCopy {

  sealed trait EventType

  final case object Entry extends EventType

  final case object Exit extends EventType

  case class Event(eventType: EventType, person: String)

  sealed trait State {
    def nextIteration(event: Event): State

    def endOfIteration(): State
  }

  final case object Start extends State {
    override def nextIteration(event: Event): State = {
      if (event.eventType.equals(Exit)) End(true)
      else NextEvent(event)
    }

    override def endOfIteration(): State = End(false)
  }

  final case class NextEvent(previousEvent: Event) extends State {
    override def nextIteration(event: Event): State = {
      previousEvent.eventType match {
        case Entry => if (event.eventType.equals(Exit)) NextEvent(event) else End(true)
        case Exit => if (event.eventType.equals(Entry)) NextEvent(event) else End(true)
      }
    }

    override def endOfIteration(): State = {
      if (previousEvent.eventType.equals(Entry)) End(true) else End(false)
    }
  }

  final case class End(result: Boolean) extends State {
    override def nextIteration(event: Event): State = this

    override def endOfIteration(): State = this
  }

  def findBadAnomaly(eventList: List[Event]): List[String] = {
    val personList: List[String] = eventList.map(event => event.person).distinct
    val myEventList: List[List[Event]] = personList.map(person => eventList.filter(event => event.person == person))
    val result = myEventList.map(events => (events.head.person, events.foldLeft[State](Start) { (state, event) => state.nextIteration(event) }.endOfIteration().asInstanceOf[End].result))
    result.filter(events => events._2).map(events => events._1)
  }

}
