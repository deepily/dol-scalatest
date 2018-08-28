package com.foo.bar.qra.test

import com.foo.bar.qra._
import org.scalatest._

class Rules000Through002Test extends FunSuite with BeforeAndAfter with Matchers {

  before {
    println( "Running BEFORE block..." )
  }
  after {
    println( "Running AFTER block..." )
  }

  test( "Test Rule 000" ) {

    val rule = new Rule000()
    rule.getRule() should not equal rule.noRule
  }
  test( "Test Rule 001" ) {

    val rule = new Rule001()
    rule.getRule() should not equal rule.noRule
  }
  test( "Test Rule 002" ) {

    val rule = new Rule002()
    rule.getRule() should not equal rule.noRule
  }
}
