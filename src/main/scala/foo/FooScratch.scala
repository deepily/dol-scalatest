package foo

object FooScratch extends App {

  println( "FooScratch?" )

  var coreProgramResult: Array[Array[Any]] = null
  coreProgramResult = Array.ofDim[Any]( 32, 428 )

  for ( i <- 0 until coreProgramResult.length ) {
    coreProgramResult( i )( 0 ) = i * 10
  }
  println( coreProgramResult )

  // get class type
  println( coreProgramResult.getClass )

  // From: https://stackoverflow.com/questions/3328085/scala-printing-arrays
  println( coreProgramResult.deep.mkString( "\n" ) )
}
