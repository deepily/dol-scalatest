package foo


/**
  * Toasting access to a hash of arrays
  */
object FooHash extends App {

  val wibListLen = 32
  val arrayLen = 64  // is 428(?!?) IRL

  // declare empty array
  var coreProgramResult: Array[Array[Any]] = null

  // declare empty map
  var coreProgramResultMap = Map[ Any, Array[ Any ] ]()

  // initialize wiblist w/ dummy values: 1 through wibListLen * 2, by twos
  var wibList = List.range( 0, wibListLen * 2, 2 )

  // initialize map...
  wibList.foreach(

    // ...using wibList item as the key for map
    item => coreProgramResultMap += ( item -> Array.fill( arrayLen - 1 )( null ) )
  )
  // initialize array of arrays
  coreProgramResult = Array.ofDim[ Any ]( wibList.length, arrayLen )
  for ( i <- 0 until wibList.length) {
    // the first element of every array is its key (according to shiva)
    coreProgramResult( i )( 0 ) = wibList( i )
  }
  //println( coreProgramResultMap )

  // iterate map coreProgramResultR
  val row = 0
  val col = 3
  coreProgramResultMap( row )( col ) = 777777

  coreProgramResultMap foreach {
    case ( key, fooArray ) => println ( key + " --> " + fooArray.mkString( "," ).replaceAll( "null", "" ) )
  }

  // iterate array
  for ( result <- coreProgramResult ) {
    println( result.mkString( "," ).replaceAll( "null", "" ) )
  }

  // getCoreQprResult
  var rowsCoreProgram = coreProgramResult.map( _.map( str=> Option( str ).getOrElse( "?" ) ) ).map { x => List( x:_* ) }
  rowsCoreProgram.foreach( println )


  //val rowsCoreProgram = coreProgramResult.map(_.map(str=> Option(str).getOrElse(""))).map { x => Row(x:_*)}
  println( "One row [" + coreProgramResultMap( 0 ).mkString( "," ).replaceAll( "null", "" ) + "]" )
}
