object Events {

  sealed trait EventType

  final case object Entry extends EventType

  final case object Exit extends EventType

  case class Event(eventType: EventType, person: String)

  sealed trait State {
    def nextEvent(event: Event): State

    def endOfEvents(): State
  }

  final case object Start extends State {
    override def nextEvent(event: Event): State = {
      if (event.eventType == Exit) End(true)
      else IterateOnEvents(event)
    }

    override def endOfEvents(): State = End(false)
  }

  final case class IterateOnEvents(previousEvent: Event) extends State {
    override def nextEvent(event: Event): State = {
      previousEvent.eventType match {
        case Entry => if (event.eventType == Exit) IterateOnEvents(event)
        else End(true)
        case Exit => if (event.eventType == Entry) IterateOnEvents(event)
        else End(true)
      }
    }

    override def endOfEvents(): State = if (previousEvent.eventType == Entry) End(true) else End(false)
  }

  final case class End(anomaly: Boolean) extends State {
    override def nextEvent(event: Event): State = this

    override def endOfEvents(): State = this
  }

  def findAnomaly(events: List[Event]): List[String] = {
    val persons: List[String] = events.map(event => event.person).distinct
    val ourEventList: List[List[Event]] = persons.map(person => events.filter(event => event.person == person))
    val result: List[(String, Boolean)] = ourEventList.map(events => (events.head.person, events.foldLeft[State](Start) { (state, event) => state.nextEvent(event) }.endOfEvents().asInstanceOf[End].anomaly))
    result.filter(result => result._2).map(result => result._1)
  }

}
