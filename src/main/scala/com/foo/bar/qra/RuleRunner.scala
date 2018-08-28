package com.foo.bar.qra

//import org.scalatest.FlatSpec

/**
  * PoC for dynamically instantiating rule objects and running them
  */
object RuleRunner {

  /** Start here!
    *
    * @param args: args( 0 ) = begining index, args( 1 ) = end index, setting both to same number allows us to run *ONE* rule
    */
  def main( args: Array[ String ] ) {

    println( "Welcome to Rule Runner" )

    val foo = "1st parameter?"
    val bar = "2nd parameter!"

    // get passed in values
    val begin = args( 0 ).toInt
    val end = args( 1 ).toInt

    for (i <- begin to end) {

      print( s"[$i]th iteration: ")

      // set format of index to 3 digit string
      val padded_index = "%03d".format( i )
      // From: http://www.avajava.com/tutorials/lessons/how-do-i-instantiate-an-object-of-a-class-via-its-string-name.html?page=2
      val classByName = Class.forName("com.foo.bar.qra.Rule" + padded_index )
      val rule = classByName.newInstance.asInstanceOf[ BaseRuleTrait ]
      rule.setParams( foo, bar )

      val ( return_one, return_two ) = rule.getResults()
    }
  }
}
