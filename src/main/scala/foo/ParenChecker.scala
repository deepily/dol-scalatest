package foo

object ParenChecker extends App {
  


  val sqlString = s"""SELECT count( UniqueIndividualIdentifierWIOA ) AS count
FROM edrvs
WHERE AdultWIOA > 0 AND AdultWIOA < 4 AND  ( ( length( DateOfProgramEntryWIOA ) > 0 AND DateOfProgramEntryWIOA != "" )
AND DateOfProgramEntryWIOA <= to_date( '2018-09-30' ) )
AND ( ( DateOfProgramExitWIOA >= to_date( '2017-10-01' )
AND  DateOfProgramExitWIOA <= to_date( '2018-09-30' ) )
or length(DateOfProgramExitWIOA)=0 )
AND ( length( DateEnrolledDuringProgramParticipationInAnEducatio ) > 0 )
AND DateCompletedDuringProgramParticipationAnEducation IS NULL
AND ( OtherReasonsForExitWIOA IN ( "00", "07", "" ) )
AND ( ( ( length( DateOfMostRecentMeasurableSkillGainsEducationalFun ) > 0 )
AND ( DateOfMostRecentMeasurableSkillGainsEducationalFun >= to_date( '2017-10-01' )
AND DateOfMostRecentMeasurableSkillGainsEducationalFun <= to_date( '2018-09-30' ) ) )
OR ( ( length( DateAttainedRecognizedCredentialWIOA ) > 0 )
AND ( DateAttainedRecognizedCredentialWIOA >= to_date( '2017-10-01' )
AND  DateAttainedRecognizedCredentialWIOA <= to_date( '2018-09-30' )
AND TypeOfRecognizedCredentialWIOA = 1 and length(TypeOfRecognizedCredentialWIOA)>0 ) )
OR ( ( length( DateAttainedRecognizedCredential2 ) > 0 )
AND ( DateAttainedRecognizedCredential2 ) >= to_date( '2017-10-01' )
AND DateAttainedRecognizedCredential2 <= to_date( '2018-09-30' )
AND (TypeOfRecognizedCredential2 = 1 and length( TypeOfRecognizedCredential2 ) > 0 ) ) )
OR ( ( length( DateAttainedRecognizedCredential3 ) > 0 )
AND ( DateAttainedRecognizedCredential3 >= to_date( '2017-10-01' )
AND DateAttainedRecognizedCredential3 <= to_date( '2018-09-30' )
AND (TypeOfRecognizedCredential3 = 1 and length( TypeOfRecognizedCredential3 ) > 0 ) ) )
OR ( ( ( length( DateOfMostRecentMeasurableSkillGainsSecondaryTrans ) > 0 ) )
AND ( DateOfMostRecentMeasurableSkillGainsSecondaryTrans >= to_date( '2017-10-01' )
AND DateOfMostRecentMeasurableSkillGainsSecondaryTrans <= to_date( '2018-09-30' ) ) )
OR ( ( ( length( DateOfMostRecentMeasurableSkillGainsPostsecondaryT ) > 0 ) )
AND ( DateOfMostRecentMeasurableSkillGainsPostsecondaryT >= to_date( '2017-10-01' )
AND DateOfMostRecentMeasurableSkillGainsPostsecondaryT <= to_date( '2018-09-30' ) ) )
OR ( ( ( length( DateOfMostRecentMeasurableSkillGainsTrainingMilest ) > 0 ) )
AND ( DateOfMostRecentMeasurableSkillGainsTrainingMilest >= to_date( '2017-10-01' )
AND DateOfMostRecentMeasurableSkillGainsTrainingMilest <= to_date( '2018-09-30' ) ) )
OR ( ( ( length( DateOfMostRecentMeasurableSkillGainsSkillsProgress ) > 0 ) )
AND ( DateOfMostRecentMeasurableSkillGainsSkillsProgress >= to_date( '2017-10-01' )
AND DateOfMostRecentMeasurableSkillGainsSkillsProgress <= to_date( '2018-09-30' ) ) ) and SpecialProjectId1 not like '48HARV1' and SpecialProjectId2 not like '48HARV1' and SpecialProjectId3 not like '48HARV1'"""

  val openCount = sqlString.count( _ == '(' )
  val closeCount = sqlString.count( _ == ')' )

  println( "open: " + openCount )
  println( "close: " + closeCount )
}
