package com.foo.bar.qra

trait BaseRuleTrait {

  var foo:String = "N/A"
  var bar:String = "N/A"

  var noRule = "No rule set yet!"

  def setParams( l_foo:String, l_bar:String ): Unit = {
    foo = l_foo
    bar = l_bar
  }
  def getRule():String = noRule

  def getResults(): ( String, String )
}
