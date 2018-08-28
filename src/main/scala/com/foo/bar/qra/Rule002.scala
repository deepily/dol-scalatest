package com.foo.bar.qra

class Rule002 extends BaseRuleTrait {

  override def getResults(): ( String, String ) = {

    println( s"Rule002.getResults() returning [$foo], bar[$bar]" )
    ( foo, bar )
  }
}
