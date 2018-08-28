package com.foo.bar.qra

class Rule001 extends BaseRuleTrait {

  override def getResults(): ( String, String ) = {

    println( s"Rule001.getResults() returning [$foo], bar[$bar]" )
    ( foo, bar )
  }
}
