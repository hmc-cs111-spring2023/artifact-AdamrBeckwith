package rollMakerLib

import scala.util.Random

import com.datawizards.splot.api.implicits._
import scala.collection.mutable.ListBuffer

// %https://github.com/piotr-kalanski/SPlot%

// class RollMakerLib 
case class Dice(number: Int, size: Int, sides: List[Int]) {
    def roll() : Int = {
        val rand = new Random
        var result = 0
        for (i <- 1 to number) {
            var midoutput = sides(rand.between(0, size))
            result = result + midoutput
        }
        result
    }
    def max() : Int = sides.max*number
}


case class Expression(dices: List[Dice], bonus: Int) {
    def roll() : Int = {
        var result = 0
        for (die <- dices) {
            result = result + die.roll()
        }
        result + bonus 
    }
    def max() : Int = { 
        var max = 0 
        for (die <- dices) {
            max = max + die.max()
        }
        max + bonus
    }

    def `++`(expr2: Expression): Expression = Expression(dices ++ expr2.dices, bonus + expr2.bonus)
}

case class Roll(name: String, die: Expression) {

}


def evaluate(t: List[Roll]) = {
      for (i <- t ) { 
        print("Test Roll Result for " + i.name + " is ")
        println(i.die.roll())

        if (i.name == "main") { 
            statistics(i) 
        }
      }   
    }

def statistics(main: Roll) = {
    val sampleSize = 1000
    val dierollmax = main.die.max()+1
    print("got this far")
    var results = ListBuffer.fill(dierollmax)(0)
    for (i <- 1 to sampleSize) {
        val rollValue = main.die.roll()
        results(rollValue) = results(rollValue)  +1    
    }

    val plotable = results.to(List)

    println(" Roll Result | Frequency")
    println("             | ")
    var firstPrint = false
    var result = 0
    val max = plotable.max
    for (number <- plotable) {
        if ((number != 0) || firstPrint ) then
            val spaceCount = 12 - result.toString().length
            val relativeSize = ((number*30)/max)

            print(" "*spaceCount)
            print(result)
            print(" | ")
            println("X"*relativeSize)
            firstPrint = true
        result += 1
    }

  

}
   