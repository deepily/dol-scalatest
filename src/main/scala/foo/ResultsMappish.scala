package foo

import scala.collection.mutable.ListBuffer

/**
  * A behave-alike kludge for b0rk3d Map object, designed to hold name=value pairs of strings
  */
class ResultsMappish {

  private var nameValuePairs = ListBuffer[String]()
  private var debugging = false

  def setDebugging( d: Boolean ): Unit = {
    debugging = d
  }
  /**
    * Adds new name=value pair to buffer, removing any duplicate name= prefixes first
    */
  def add(name: String, value: String): Unit = {

    val nameValuePair = name + "=" + value

    // TODO: Filter would accomplish the same thing
    // remove anything that begins with prefix
    var idx = nameValuePairs.indexWhere( _.startsWith( name + "=" ) )

    // TODO: we only need to do this once per addition, since by definition there can be no duplication of prefixes, right?
    while ( idx > -1 ) {

      if ( debugging ) println( s"Removing element @ [$idx]..." )
      nameValuePairs.remove( idx )

      // find next occurrence
      idx = nameValuePairs.indexWhere( _.startsWith( name + "=" ) )
    }

    nameValuePairs += nameValuePair
  }

  /**
    * Gets value associated with name=value pair.  Returns zero-len string if key isn't found, or if key has a zero-len string
    * associated with it
    * @param prefix
    * @return
    */
  def get(prefix: String): String = {

    get( prefix, "" )
  }

  /**
    * Gets value associated with name=value pair.  Returns default value if not found
    * @param prefix
    * @param default
    * @return
    */
  def get(prefix: String, default: String ): String = {

    // default value is ""
    var result = default
    val idx = nameValuePairs.indexWhere(_.startsWith(prefix + "="))

    if (idx != -1) {
      val pair = nameValuePairs(idx).split("=")
      if (pair.length == 2) {
        result = pair(1)
      }
    }
    result
  }
  /**
    * Gets a derived list of name prefixes from nameValuePairs
    * @return
    */
  def keys(): List[ String ] = {

    var prefixes = ListBuffer[String]()

    for ( pair <- nameValuePairs ) {
      prefixes += pair.split( "=" )( 0 )
    }
    prefixes.toList
  }
  def reset(): Unit = {
    nameValuePairs = ListBuffer[String]()
  }

  /**
    * Gets name=value pairs as a list of String tuples
    * @return ( name, value )
    */
  def pairs(): List[ ( String, String ) ] = {

    var pairs = ListBuffer[ ( String, String ) ]()
    var name = ""
    var value = ""
    var p = Array[ String ]()

    for ( pair <- nameValuePairs ) {

      p = pair.split( "=" )
      name = p( 0 )

      if ( p.length == 2 ) {
        value = p( 1 )
      } else {
        value = ""
      }

      pairs += ( ( name, value ) )
    }
    pairs.toList
  }
}

object  ResultsBufferDemo {

  def main(args: Array[String]): Unit = {

    val foo = new ResultsMappish()

    foo.add( "Z29", "292929292929292929292929" )
    foo.add( "A2", "22222" )
    foo.add( "A1", "1111111" )
    foo.add( "A1", "oneoneoneoneoneone" )
    foo.add( "A1", "uno uno uno" )
    foo.add( "A3", "333" )

    println( s"A2 = [${foo.get( "A1" )}]" )
    println( s"Z7 = [${foo.get( "Z7" )}]" )
    println( s"Z7 = [${foo.get( "Z7", "MISSING" )}]" )

    println( "======== pairs ======= " )
    for ( pair <- foo.pairs() ) {
      println( pair )
    }
    println( "======== keys ======= " )
    for ( key <- foo.keys() ) {
      println( key )
    }
    println( "======== keys and fetched values ======= " )
    for ( key <- foo.keys() ) {
      println( s"key [$key] = [${foo.get( key )}]" )
    }
  }
}
