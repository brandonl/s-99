import sbt._
import sbt.Keys._

object BuildSettings {
  val buildSettings = 
  	Defaults.defaultSettings ++ 
  	Seq(
	    organization        := "com.github.brandonl",
	    version             := "0.1-SNAPSHOT",
	    scalaVersion        := "2.10.0",
	    scalacOptions       := Seq("-unchecked", "-deprecation", "-feature"),
	    resolvers           ++= Seq(
	      "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
	      "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
    )
  )
}

object Build extends Build {
	import BuildSettings._

	lazy val threadRace = Project (
		"s-99",
		file("."),
		settings = buildSettings ++ Seq(
      libraryDependencies := Seq(
        Dependencies.Compile.ScalaLogging,
				Dependencies.Test.ScalaTest,
				Dependencies.Test.ScalaCheck
      )
    )
	)

	object Dependencies {
		
		object Compile {
		  val ScalaLogging = "com.typesafe" %% "scalalogging-slf4j" % "1.0.+"
		  val ScalaConfig = "com.typesafe" % "config" % "1.0.0"
		  val LogbackCore = "ch.qos.logback" % "logback-core" % "1.0.+"
		  val LogbackClassic = "ch.qos.logback" % "logback-classic" % "1.0.+"
		}

	  object Test {
	    val Specs2 = "org.specs2" %% "specs2" % "1.12.3" % "test"
	    val Mockito = "org.mockito" % "mockito-all" % "1.9.0" % "test"
	    val Hamcrest = "org.hamcrest" % "hamcrest-all" % "1.1" % "test"
	    val ScalaCheck = "org.scalatest" %% "scalatest" % "1.9.+" % "test"
	    val ScalaTest = "org.scalacheck" %% "scalacheck" % "1.10.+" % "test"
	  }
	}
}

