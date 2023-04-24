
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
    "roll" ~ name ~ "{" ~ expression ~ "}" ^^ {
      case _ ~ name ~ _ ~ expression1 ~ _ =>
        Roll(name, expression1)
    }
  
  def expression: Parser[Expression] = 
    dice ~ "+" ~ expression  ^^ {case dice1 ~ _ ~ expression1 => Expression(List(dice1), 0) ++ expression1}
    | number ~ "+" ~ expression ^^ {case int1 ~ _ ~ expression1 => Expression(List(), int1) ++ expression1}
    | dice ^^ {case dice1 => Expression(List(dice1), 0)}
    | number ^^ {case int1 => Expression(List(), int1)}
   

  
  def dice: Parser[Dice] = 
    (number ~ "d" ~ number ^^ {
      case int1 ~ _ ~ int2 => Dice(int1, int2, List.range(1,int2+1))
    })
    | (number ~ "d" ~ listInt ^^ {
      case int1 ~ _ ~ list1 => Dice(int1, list1.size, list1)
    })
    // | name ^^ {case name1 => {
    //     for(roll <- program.a) {
    //       if(name = roll.name) {
    //         roll.die
    //         Break
    //       }
    //     }
    //     Error("Roll Name Not Found")
    //   }
    // }
    
  def listInt: Parser[List[Int]] =
    ("[" ~ number ~ listInt) ^^ { case _ ~ int1 ~ listInt1 =>  int1 :: listInt1} 
    | ("," ~ number ~ listInt) ^^ { case _ ~ int1 ~ listInt1 => int1 :: listInt1} 
    | ("]") ^^ {case _ => List()}


  def name: Parser[String] = 
    """[a-z]+""".r   ^^ { _.toString }
  
  def number: Parser[Int] =
    """(0|[1-9]\d*)""".r ^^ { _.toInt }
}
