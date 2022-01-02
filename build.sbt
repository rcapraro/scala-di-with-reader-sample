ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val root = (project in file("."))
  .settings(
    name := "scala-di-with-reader-sample"
  )

libraryDependencies += "org.typelevel" %% "cats-core" % "2.7.0"