package foo

object FooSplat extends App {

  def printAll( strings: String* ) {
    println("------")
    strings.foreach( println )
  }

  val bugs = List( "What's", "up", "doc?" )
  printAll( bugs: _* )
}
