package foo

object ArrayAccess extends App {

  val rows = 4
  val cols = 8
  var arrayOfArrays = Array.ofDim[ Int ]( rows, cols )

  for ( i <- 0 to arrayOfArrays.length - 1 ) {
    arrayOfArrays( i ) = Array.fill[ Int ]( cols )( i * 2 )
  }
  println( arrayOfArrays.deep.mkString( "," ) )

  println( arrayOfArrays.slice( 0, 3 )( 0 ).mkString( "," ) )
}
