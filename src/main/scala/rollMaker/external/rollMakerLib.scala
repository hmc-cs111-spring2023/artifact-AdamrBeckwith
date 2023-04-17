package rollMakerLib

import scala.util.Random

import com.datawizards.splot.api.implicits._
import scala.collection.mutable.ListBuffer

// %https://github.com/piotr-kalanski/SPlot%

// class RollMakerLib 
case class Dice(number: Int, size: Int){
    def roll() : Int = {
        val rand = new Random
        var result = 0
        for (i <- 1 to number) {
            var midoutput = rand.between(1, size) 
            result = result + midoutput
        }
        result
    }
}

case class Roll(name: String, die: Dice) {
    
}

def evaluate(t: List[Roll]) = {
      for (i <- t ) { 
        print("Roll Result for " + i.name + " is ")
        println(i.die.roll())

        if (i.name == "main") { 
            statistics(i) 
        }
      }   
    }

def statistics(main: Roll) = {
    val sampleSize = 100
    var results = ListBuffer.fill(main.die.size*main.die.number)(0)
    for (i <- 1 to sampleSize) {
        val rollValue = main.die.roll()
        results(rollValue) = results(rollValue)  +1    
    }

    // val plotable = ListBuffer[(Int,Int)]
    // for (i <- 1 to sampleSize) {
    //     plotable += Seq(i,results(i))
    // }
    // plotable
    //     .buildPlot()
    //     .titles("Population by country [millions]", "Country", "Population")
    //     .size(1200, 300)
    //     .legendVisible(false)
    //     .display()
        // .bar(_._1, _._2)

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


