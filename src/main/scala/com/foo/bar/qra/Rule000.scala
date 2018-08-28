package com.foo.bar.qra

/** Implements 000th rule of WIOA Quarterly Report Agg
  *
  * @author rruiz
  */
class Rule000 extends BaseRuleTrait {

  override def getRule(): String = {

    val rule = """
      Count of UNIQUE RECORDS where ((Funding Stream) and (Most Recent Date Received Basic Career Services  (Staff-Assisted)
      is not null and Date of First Individualized Career Service is null and Received Training = 0)) and DATE OF EXIT is within
      the reporting period."""

    rule
  }

  override def getResults(): ( String, String ) = {

    println( s"Rule000.getResults() returning [$foo], bar[$bar]" )
    ( foo, bar )
  }
}
