package foo

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateMinusThreeMonths extends App {

  val endDate = "2018-06-30"
  val dt = LocalDate.parse( endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd" ) )
  println( endDate )
  println( dt.minusMonths( 3 ) )
  println( dt.plusDays( 1 ).minusMonths( 3 ) )
}
