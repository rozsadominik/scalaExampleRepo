import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import MovieDatabase._

class MovieDatabaseSuite extends AnyFlatSpec with should.Matchers {
  "movie" should "doIt" in {
    println(directorsWithBackCatalogOfSize(3))
    println(directorBornBefore(2000))
    println(directorBornBeforeWithBackCatalogOfSize(2000, 3))
    println(directorsSortedByAge(false))
    println(directorsSortedByAgeNext(false))

  }
}
