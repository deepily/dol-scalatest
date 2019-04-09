package foo

import java.io.{BufferedWriter, File, FileWriter}
import java.nio.file.{Files, Paths}

import scala.collection.mutable.Map
import scala.io.Source

object FileAppender extends App {

  private var startMillis = 0L
  private val debugging = true
  private val resultsMapCacheFile = File.createTempFile("results-cache-", ".txt" )
  private var resultsMap = Map[ String, String ]().withDefaultValue( "" )

  def appendToFile( line: String ) = {

    if (debugging) {
      println("\n\n=====================================================================================")
      println("= appendToFile: ")
      println("=====================================================================================")
    }
    startMillis = System.currentTimeMillis()
    val bw = new BufferedWriter(new FileWriter( resultsMapCacheFile, true ) )

    try {

      bw.write( line )
      bw.write( "\n" )

    } catch {

      case ex: Exception => println(s"ERROR writing to [${resultsMapCacheFile.toPath}]: [$ex.toString]")

    } finally {

      bw.close()
    }
    println( s"Time to append one line [${System.currentTimeMillis() - startMillis}]ms" )
  }

  private def loadResultsMapCache(): Unit = {

    val startMillis = System.currentTimeMillis()
    val bufferedSource = Source.fromFile( resultsMapCacheFile )

    var pair = Array[String]()
    var trimmedLine = ""
    for ( line <- bufferedSource.getLines ) {

      trimmedLine = line.trim

      // skip commented or empty lines
      if ( !trimmedLine.startsWith( "//" ) && trimmedLine != "" ) {

        // trim and split line
        pair = trimmedLine.split("=" )
        if (pair.length == 2) {
          resultsMap += pair(0) -> pair(1)
        } else {
          // allow expected values to be zero-len strings
          resultsMap += pair(0) -> ""
        }
        //if (debugging) println(s"Expected results pair [$trimmedLine]")
      }
    }
    bufferedSource.close

    if (debugging) {

      println("\n\n=====================================================================================")
      println("= resultsMap: ")
      println("=====================================================================================")

      for ( key <- resultsMap.keys ) {
        println( s"key [$key] = [${resultsMap( key )}]" )
      }
      println( s"Time to reload resultsMap [${System.currentTimeMillis() - startMillis}]ms" )
    }
  }

  appendToFile( "Foo=bar" )
  loadResultsMapCache()
  appendToFile( "Up=Down" )
  loadResultsMapCache()
  appendToFile( "Left=Right" )
  loadResultsMapCache()
  appendToFile( "Hot=" )
  loadResultsMapCache()
  appendToFile( "Good=Evil" )
  loadResultsMapCache()
}
