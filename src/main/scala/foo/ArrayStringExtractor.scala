package foo

object ArrayStringExtractor extends App {

  // val SUBSETS = List( "AK", "AL", "AR", "AS", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MP", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR", "PW", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VI", "VT", "WA", "WI", "WV", "WY" )
  //val SUBSETS = List( "PIRL 1000", "PIRL 1001", "PIRL 1002", "PIRL 1100", "PIRL 1101", "PIRL 1102", "PIRL 1103", "PIRL 1104", "PIRL 1105", "PIRL 1107", "PIRL 1112", "PIRL 1113", "PIRL 1201", "PIRL 1602", "PIRL 1606", "PIRL 1704", "PIRL 202", "PIRL 301", "PIRL 401", "PIRL 413", "PIRL 808", "PIRL 900", "PIRL 901", "PIRL 904", "PIRL 918", "PIRL 923", "PIRL 3000" )
  val SUBSETS = List( "p1000", "p1001", "p1002", "p1007", "p1100", "p1101", "p1102", "p1103", "p1104", "p1105", "p1107", "p1112", "p1113", "p1201", "p900", "p901", "p3000" )

  for ( subset <- SUBSETS ) {
    println( subset )
  }
}
