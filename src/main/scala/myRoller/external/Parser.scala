package myRoller.external

import scala.util.parsing.combinator._

import picolib.semantics._

/*
 * Syntax for a valid Picobot rule:
 *
 *          rule ::= state pattern "->" direction state
 *       pattern ::= ndirection edirection wdirection sdirection
 *    ndirection ::= "N" | odirection
 *    edirection ::= "E" | odirection
 *    wdirection ::= "N" | odirection
 *    sdirection ::= "S" | odirection
 *    odirection ::= "*" | "x"
 *     direction ::= "N" | "E" | "W" | "S" | "x"
 *         state ::= digit{digit}
 *
 */

object MyRollerParser extends RegexParsers {

  // for parsing comments
  override protected val whiteSpace = """(\s|#.*)+""".r

  // parsing interface
  def apply(s: String): ParseResult[List[Rule]] = parseAll(program, s)

  
}
