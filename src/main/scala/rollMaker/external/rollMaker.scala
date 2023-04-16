import Console.{RED, RESET}

import rollMakerLib.*

// import rollMaker.external.rollMakerParser

@main
def main(args: String*) = {

  // Error handling: did the user pass two arguments?
  if (args.length !=  1) {
    println(error(usage))
    sys.exit()
  }


  // parse the program file
  val programFilename = args(0)
  val program = rollMakerParser(getFileContents(programFilename))

  // process the results of parsing
  program match {
    // Error handling: syntax errors
    case e: rollMakerParser.NoSuccess => println(error(e.toString))

    // If parsing succeeded, create the bot and run it
    case rollMakerParser.Success(t, _) => {
      println("Parse Successful")
      for (i <- t ) { 
        evaluate(i) 
      } 
      
    }
  }
}

/** A string that describes how to use the program * */
def usage = "usage: sbt run <program-file>"

/** Format an error message */
def error(message: String): String =
  s"${RESET}${RED}[Error] ${message}${RESET}"

/** Given a filename, get a list of the lines in the file */
def getFileLines(filename: String): List[String] =
  try {
    io.Source.fromFile(filename).getLines().toList
  } catch { // Error handling: non-existent file
    case e: java.io.FileNotFoundException => {
      println(error(e.getMessage())); sys.exit(1)
    }
  }

/** Given a filename, get the contents of the file */
def getFileContents(filename: String): String =
  try {
    io.Source.fromFile(filename).mkString
  } catch { // Error handling: non-existent file
    case e: java.io.FileNotFoundException => {
      println(error(e.getMessage())); sys.exit(1)
    }
  }

