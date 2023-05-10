name := """json-parser"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

libraryDependencies += guice
libraryDependencies += ehcache
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies ++= Seq(

  ws,

  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
   "com.typesafe.play" %% "play-json" % "2.9.4",
  "com.softwaremill.sttp.client3" %% "core" % "3.8.12",
  "io.lemonlabs" %% "scala-uri" % "4.0.3",

  "io.spray" %% "spray-json" % "1.3.6"

)

