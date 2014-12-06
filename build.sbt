name := """cake-pattern-playground"""

version := "1.0"

scalaVersion := "2.11.4"

libraryDependencies += "org.specs2" %% "specs2-core" % "2.4.14" % "test"

scalacOptions in Test += "-Yrangepos"
