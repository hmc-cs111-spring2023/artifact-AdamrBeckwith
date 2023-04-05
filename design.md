
### Initial Design: 

This is a preliminary design but this is what I want people to be able to create and explore with the system. 
Making a roll: (basically a function that outputs a number) 
```
roll alpha {

1d6 + 7

}
```
note: 1d6 evaluates to a roll object. 

Making a check: (basically a fucntion that outputs a succes or failure -- maybe add allowance for multiple successes reported?) 
```
check beta {

5d6 if >10 

}
```
note: 5d6 evaluates to a list of 1d6's that are then each rolled by if and compared to 10 

Making a stat: (output stats with various parameters) 
```
roll gamma {
 alpha + 1d6
}

stat beta (parameters)
stat gamma (parameters)
```
This still needs some refinement. I want to break away from coding conventions, but we know thats very difficult. 

# Conversion to Regular Languages 

Now lets convert this to a valid rule system that we can convert to a full system later. 

Syntax for a valid MyRoller roll: (PS I need to think of a better name): 
```
*
*          roll ::= "roll" name "{" rollEquation "}"
*  rollEquation ::= rollAddition
*                   | (rollEquation)
*                   | value
*  rollAddition ::= rollEquation "+" rollEquation 
*         value :: dice | num 
*          dice ::= num "d" num
*           num ::= digit{digit}
*          name ::= string{string}
```
Most importantly this is only one implementation of something like addition. "RollEquation" would eventually have to be expanded to cover things like filtering and if statements :0 which is significantly differently. The question then is *how can I implement if statements so they are fundementally different then me just implementing this as a internal language and using what already exists. 

Very important issue here a roll evaluates to a function, rather then a direct thing. So lazyness may be required here. 
In short  `roll "damage" { 1d6 + 5 }` evaluates to  `damage(): 1*rand(1,6) + 5 ` rather a specific roll result. 

