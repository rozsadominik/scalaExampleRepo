import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import HillCopy._

class HillCopySuite extends AnyFlatSpec with should.Matchers {

  "this test" should "work" in {
    println(findLocaleMaxInNumberList(List(5, 4, 5, 55, 55, 55, 4, 3, 6)))

    println(findLocaleMaxInNumberList(List(5, 3, 2, 4, 4, 4, 2)))


    val words = Map("All" -> "Weather", "Portfolio" -> "Alpha", "Optimal" -> "Portfolio")
    println(words.map { case (key, value) => if (key.startsWith("A") || key.startsWith("O")) value.take(3) })

    val lazyDog = "The dog quickly jump ahead"

    println(lazyDog.split(" ").toList.reverse.mkString)

    val listOfCars = List(Map("brand" -> "Honda", "quantity" -> 500),
      Map("brand" -> "Honda", "quantity" -> 150),
      Map("brand" -> "BMW", "quantity" -> 500))


    println(listOfCars.groupBy(map => map("brand")))

    val groupedMap = listOfCars.groupBy(map => map("brand"))

    groupedMap.map {
      case (key, value) => value.map(cars => cars("quantity").asInstanceOf[Int]).sum
    }

    val hondaList = listOfCars.map(map => if (map.head._2 == "Honda") map.tail.head._2.asInstanceOf[Int] else 0)

    println(hondaList.sum)

    def sum(listOfCar: List[Int], result: Int): Int = {
      listOfCar match {
        case head :: tail => sum(tail, result + head)
        case Nil => result
      }
    }

    println(sum(hondaList, 0))

    println(hondaList)
    println(listOfCars.map(map => map.tail.head._2))
    println(listOfCars.filter(map => map.head._2 == "Honda"))

    // brands
    val brands = listOfCars.map(map => map.head._2).distinct

    println(brands.map(brand => listOfCars.filter(map => map.head._2 == brand)))


    val x = if (true) 1 else 3.0
    println(x)


    val a = Seq(1, 2, 3)
    val b = a
    val d = b.reduce((x, y) => x max y)

    val cmi: Seq[(Int, Int)] = a.zip(b).filter(ints => ints._2 > 2)
    println(a.zip(b))

    val n: Option[Seq[Int]] = Option(a.tail)
    println(n)

    val m: Map[String, IterableOnce[Any] with Equals] = Map("n" -> Option(a.tail), "m" -> a)

    val j: Seq[Int] = cmi.map(ints => ints._2 + 1)

    val p: IterableOnce[Any] with Equals = m("n")


  }

}
