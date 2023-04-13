package rollMakerLib

import scala.util.Random


class RollMakerLib 

    case class Die(size: Int){
        def roll() : int = {
            val rand = new Random
            rand.nextInt
        }
    }
    
    case class Roll(name: String, number: Int, die: Die) {
        def evaluate(roll: Roll) = {
            for(i <- 1 to roll.number) {
                print(roll.die.roll())
            }
        }
    }


    // def rand = new Random()

    // class Roll() =
    //     def initfunct : Unit => List[Int] 
    //     def functs : List[List[Int] => List[Int]]

    //     def eval() 
    //         value = initfunct()
    //         for i <- functs {
    //             value = i(value)
    //         }
    //         value 
    // end Roll

    // def Dice(number: Int, options : List[Int]) :  
    //     () => {
    //         for i <- (1 to number) {
                
    //         }
    //     }


