package rollMakerLib

import scala.util.Random


// class RollMakerLib 
case class Dice(number: Int, size: Int){
    def roll() : Int = {
        val rand = new Random
        var result = 0
        for (i <- 0 to number) {
            result = result + rand.between(1, size) 
        }
        result
    }
}

case class Roll(name: String, die: Dice) {
    
}

def evaluate(roll: Roll) = {
        for(i <- 1 to roll.die.number) {
            print("Roll Result for " + roll.name + " is ")
            print(roll.die.roll())
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


