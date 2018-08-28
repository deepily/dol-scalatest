package com.foo.bar.qra.test

import com.foo.bar.qra._
//import org.scalatest.Assertions._
import org.scalatest._

object Rule001Test extends FlatSpec with Matchers with App {

  val rule = new Rule001()

  // simple way to check rule text
  //assert( rule.getRule() != rule.noRule )

  // more natural?
  rule.getRule() should not equal rule.noRule
}
