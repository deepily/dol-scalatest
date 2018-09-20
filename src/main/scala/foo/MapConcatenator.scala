
package foo

import scala.collection.immutable.Map
import scala.collection.mutable.ListBuffer

object MapConcatenator extends App {

  var coreProgramResultMap = Map[ String, Array[ Any ] ]()

  val labels = List( "1st", "2nd", "3rd" )

  for ( label <- labels ) {

    coreProgramResultMap += ( label -> Array.fill( 8 )( null ) )
  }

  println( coreProgramResultMap )

  //var listOfKeysAndValues = List[ String ]()
  var listOfKeysAndValues = new ListBuffer[ String ]()

  coreProgramResultMap foreach {
    case ( key, fooArray ) => {
      println ( key + " --> " + fooArray.mkString( "," ).replaceAll( "null", "" ) )

      // make a big string, w/ key in 0th place?
      val newRow = key + "," + fooArray.mkString( "," ).replaceAll( "null", "" )
      println( "newRow: "+ newRow )
      listOfKeysAndValues += newRow
    }
  }
  println( "listOfKeysAndValues: " + listOfKeysAndValues.mkString( "\n" ) )
}
