package foo

import java.text.NumberFormat

object NumberFormatter extends App {

  val bigNumber = 10000000000L
  val commaFormatter = NumberFormat.getIntegerInstance

  println( s"bigNumber [$bigNumber%i]" )
  println( s"bigNumber [${commaFormatter.format( bigNumber )}]" )
}
