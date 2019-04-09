package foo

import java.util.concurrent.ThreadLocalRandom
import java.util.Date
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.sql.Timestamp

object RandomMillis extends App {

  def getRandomDate( min: Long, max: Long, sdf: SimpleDateFormat ): String = {

    val nextLong = ThreadLocalRandom.current.nextLong( min, max )
    sdf.format( new Date( nextLong ) )
  }
  val dtFormatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" )

  // Convoluted way to get a date to millis conversion, to say the least!
  // From: https://docs.oracle.com/javase/8/docs/api/java/sql/Timestamp.html and https://coderanch.com/t/651936/databases/Convert-java-time-LocalDateTime-SE
  // NOTE: This is only an approximation!
  val min = Timestamp.valueOf( LocalDate.parse( "2016-01-01", dtFormatter ).atStartOfDay() ).getTime
  val max = Timestamp.valueOf( LocalDate.parse( "2019-06-30", dtFormatter ).atStartOfDay() ).getTime

  val yearMMdd = new SimpleDateFormat( "yyyy-MM-dd" )

  for ( i <- 1 to 10 ) {
    println( s"[$i] [${getRandomDate( min, max, yearMMdd ) }]" )
  }
}
