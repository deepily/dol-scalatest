package foo

object ScopeToaster extends App {

  val foo = 3

  val bar = {
    if ( foo % 2 == 0 ) {
      "1st block"
    } else {
      "2nd block"
    }
  }
  println( bar )
}
