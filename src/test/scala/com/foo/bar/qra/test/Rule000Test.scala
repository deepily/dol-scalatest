package com.foo.bar.qra.test

import com.foo.bar.qra.Rule000
//import org.scalatest.Assertions._
import org.scalatest._

object Rule000Test extends FlatSpec with Matchers with App {

  val rule = new Rule000()

  // simple assertion
  // assert( rule.getRule() != rule.noRule )

  // more natural?
  rule.getRule() should not equal rule.noRule
}
