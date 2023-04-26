# artifact-AdamrBeckwith
Final Project Artifact for cs111 

## Introduction to RollMaker

Rollmaker is a External Domain Space Langauge for making dice rolls. It then outputs stats based on the possible results. 

## How to Run: 

Add your file to this directory and then do `sbt` to boot up sbt then do  `run <filename>` and the language will run. 

## How To Code:

Each RollMaker File contains a main element a "roll". Each roll can have a name of your choice, and a expression describing its behavior. 

You can wite a roll like this 

```
roll <name> { 
    <expression>
}
```
The roll can have any name. If it has the name *main* is used, the fill will print the results for that roll upon running. 

# Expressions: 

A roll is a sum of three elements. Either a Dice, an integer, or a name of a roll that is already defined. 

A dice is defined by a number, a character d and the number sides. So a standard 6 sided die would be `1d6`. If you wanted two of them you could `2d6` rather then `1d6 + 1d6` 

Rollmaker also allows you to define your own dice. In this case replace the number of sides with a list containing the sides you want. As an example 

```
1d[1, 3, 3, 3, 5, 6]
```
(this is Mario's dice block from *Super Mario Party*) This Dice will *roll* and choose one of the 6 sides at equal probability. 

You can combined these elements together with the addtion sign `+`. Therefore you can get 

```
roll alpha { 
    2d[0,1,2,3,8] + 1d6
}
roll main { 
    alpha + 1d8 + 7
}
```
Which, when run on rollMaker  will out outout the stats about what results the roll results in and its probability. 
By Default, these are not *calculated* statistics, rather they are expirimental. Your roll is rolled 1000 times, and compiled into a bar chart. The above result becomes: 

```
[info] Test Roll Result for alpha is 3
[info] Test Roll Result for main is 18
[info]  Roll Result | Frequency
[info]              | 
[info]            1 | X
[info]            2 | XXXXXX
[info]            3 | XXXXXXXXX
[info]            4 | XXXXXXXXXXXXXXX
[info]            5 | XXXXXXXXXXXXXXXXXXXXXXXXX
[info]            6 | XXXXXXXXXXXXXXXXXXXXXXXXXXXX
[info]            7 | XXXXXXXXXXXXXXXXXXXXXXXXXXXXX
[info]            8 | XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
[info]            9 | XXXXXXXXXXXXXXXXXXXXXXXXXXX
[info]           10 | XXXXXXXXXXXXXXXXXXXXXXXXXXX
[info]           11 | XXXXXXXXXXXXXXXXXXXXXXXXX
[info]           12 | XXXXXXXXXXXXXXXXXX
[info]           13 | XXXXXXXXXXXXXXXXXXXX
[info]           14 | XXXXXXXXXXXXXXX
[info]           15 | XXXXXXXXXXXX
[info]           16 | XXXXXXXXXXX
[info]           17 | XXXXXXXXXXX
[info]           18 | XXXXXXXX
[info]           19 | XXXX
[info]           20 | 
[info]           21 | X
[info]           22 | X
[info]           23 | X
[info]           24 | X
```
The File also does a test roll of each roll inside your file. This is for sanity checking your implementations.

# Other Examples 
See the attatched files `simpleRoll`, `simpleExpression`, `simpleSubroll` and `simpleCustom`.
