[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-f4981d0f882b2a3f0472912d15f9806d57e124e0fc890972558857b51b24a6f9.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=10339393)
[picobot]: https://www.cs.hmc.edu/twiki/bin/view/CS5/PicobotProgrammingGold
[api]: https://hmc-cs111-spring2023.github.io/docs/picolib/
[javafx]: https://gluonhq.com/products/javafx/
[emptyfile]: https://d1b10bmlvqabco.cloudfront.net/attach/ijjfckl6old4zz/hku6eqiwn313j8/il5k6nm8w0yk/empty.txt
[parsercombinatorresource]: http://bitwalker.org/posts/2013-08-10-learn-by-example-scala-parser-combinators/
[parsercombinatorapi]: https://www.scala-lang.org/api/2.12.8/scala-parser-combinators/scala/util/parsing/combinator/Parsers.html



## Syntax implementation: external DSL

If you choose to implement your syntax as an internal DSL, use [parser
combinators][parsercombinatorapi] and case classes to implement the parser. Here's a [good
article][parsercombinatorresource] for learning a bit more about parser combinators; there
are many other ones on the web.

**Note:** Your intermediate representation might be data structures from the
`picolib` library, or it might be data structures of your own design, or a
combination of both. In some cases, you might not need to create _all_ the
packages described above.

## A running diary

As you work, comment on your experience in the file `evaluation.md`. In
particular, each time you change your ideal syntax, you should describe what
changed and why you made the change (e.g., your original idea required an
operator that you couldn't implement in Scala or integrate with your other ides
). You should also answer the following questions: On a scale of 1–10 (where 10
is "a lot"), how much did you have to change your syntax? On a scale of 1–10
(where 10 is "very difficult"), how difficult was it to map your syntax to the
provided API?

### Provide instructions for building and running your external DSL

In the `build.md` file provide instructions for how to build your external DSL and how to
run it on a piconot program. Note that for your users to run your language this way, you
will have to design your solution so that the `main` function takes and processes an
argument that contains the filename of the maze file and the filename of the picobot
program. Ask for help if you're not sure how do so!
