object DivineWith3 {

  def divineThreeList(originalList: List[Int]): List[List[Int]] = {
    for {
      number <- (1 to originalList.size).toList
      resultList: List[Int] <- originalList.combinations(number).withFilter(list => list.sum % 3 == 0)
    } yield resultList
  }


}
