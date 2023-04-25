# artifact-AdamrBeckwith
Final Project Artifact for cs111 

## Introduction to RollMaker

Rollmaker is a External Domain Space Langauge for making dice rolls. It then outputs stats based on the possible results. 

## How to Run: 

Add yoru file to this directory and then do `sbt run <filename>` and the language will run. 

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

A dice is defined by a number, a character d and the sides. 