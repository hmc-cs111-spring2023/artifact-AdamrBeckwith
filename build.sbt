val scala3Version = "3.2.2"

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := scala3Version
ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-explain",
  "-language:implicitConversions",
  "-language:postfixOps"
)

ThisBuild / libraryDependencies += "com.github.piotr-kalanski" % "splot" % "0.2.0"

ThisBuild / libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
ThisBuild / libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.15.4" % Test
ThisBuild / libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.2.0"

// So that we can run GUI apps multiple times from a single sbt session
// https://github.com/scalafx/scalafx/issues/361
fork := true
