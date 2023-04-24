
import scala.util.parsing.combinator._

import rollMakerLib.*
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
    number ~ "d" ~ number ^^ {
      case int1 ~ "d" ~ int2 => Dice(int1, int2, List.range(1,int2))
    }
    


  def name: Parser[String] = 
    """[a-z]+""".r   ^^ { _.toString }
  
  def number: Parser[Int] =
    """(0|[1-9]\d*)""".r ^^ { _.toInt }
}
