package foo

object QueryString extends App {

  val uNull = "\u0000"
  val partsplit = "( AdultWIOA IN ( 1, 2, 3 ) OR DislocatedWorkerWIOA IN ( 1, 2, 3 ) OR WagnerPeyserEmploymentServiceWIOA IN ( 1 ) OR YouthWIOA IN ( 1, 2, 3 ) )"

  def missing( colName: String ): String = {
    s"""( $colName = '$uNull' OR length( $colName ) = 0 )"""
  }
  def notMissing( colName: String ): String = {
    s"""( $colName != '$uNull' AND length( $colName ) > 0 )"""
  }

  val prevmsgden = s"""( $partsplit AND DateOfProgramEntryWIOA IS NOT NULL AND DateOfProgramEntryWIOA <= to_date( '2018-06-30' ) AND ( DateOfProgramExitWIOA IS NULL OR
                  |( DateOfProgramExitWIOA  >= to_date( '2017-07-01' ) AND DateOfProgramExitWIOA  <= to_date( '2018-06-30') ) ) AND ${notMissing( "DateEnrolledDuringProgramParticipationInAnEducatio" )} AND ( ${missing( "DateCompletedDuringProgramParticipationAnEducation" )} OR
                  |( DateCompletedDuringProgramParticipationAnEducation  >= to_date( '2017-07-01' ) AND DateCompletedDuringProgramParticipationAnEducation  <= to_date( '2018-06-30') ) ) AND ( OtherReasonsForExitWIOA IN ( "00", "07", "" ) ) )""".stripMargin

  println( missing( "Foo" ) )
  println( notMissing("Bar" ) )
  println( prevmsgden )

}
