
import scala.util.parsing.combinator._

import RollMakerLib
/*
*          roll ::= "roll" name "{" dice "}"
*          dice ::= num "d" num        \\ will need to use parser combinators
*           num ::= digit{digit}
*          name ::= string{string}
 *
 */

object rollMakerParser extends RegexParsers {

  // for parsing comments
  override protected val whiteSpace = """(\s|#.*)+""".r

  // parsing interface
  def apply(s: String): ParseResult[List[Roll]] = parseAll(program, s)

  def program: Parser[List[Roll]] = roll *

  def roll: Parser[Roll] =
    "roll" ~ name ~ "{" ~ dice ~ "}" ^^ {
      case "roll" ~ name ~ "{" ~ dice ~ "}" =>
        Roll(name, dice)
    }
  
  def dice: Parser[Dice] =

  
}
