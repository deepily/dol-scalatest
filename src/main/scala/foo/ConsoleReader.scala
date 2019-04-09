package foo

import scala.io.StdIn
import sys.process._

object ConsoleReader extends App {

  var rawInput = ""
  var continue = true

  val prompt =
    s"""\n\n==========================================================================
       |Interactive mode choices:
       |==========================================================================
       | [I] init: executes init()
       | [R]  run: executes run()
       | [S] stop: executes stop()
       | [L] (re)load query defs, abbreviations and expected results
       | [R id,id,id] run comma delimited list of ids
       | [SQL] prepare to receive multiline SQL query input
       | [Q] quit hard\n\n:
     """.stripMargin
  while ( continue ) {

    rawInput = StdIn.readLine( prompt ).trim.toUpperCase()
    val inputs = rawInput.split( " " )

    println( s"You said [${inputs.mkString( "," )}]" )


    if ( inputs( 0 ).startsWith( "Q" ) ) {
      continue = false
    } else if ( inputs( 0 ) == "SQL" ) {

      var accumulatedInput = ""
      var counter = 0
      while ( rawInput != "" ) {
        rawInput = StdIn.readLine()
        accumulatedInput += s"""|[$counter]|$rawInput"""
        counter += 1
      }
      println( s"You said [$accumulatedInput]" )
    }
    //"clear" !
  }
}