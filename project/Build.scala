import sbt._
import sbt.Keys._

object BuildSettings {
  val buildSettings =
  	Defaults.defaultSettings ++
  	Seq(
	    organization        := "com.github.brandonl",
	    version             := "0.1",
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

	lazy val core = Project (
		"s-99",
		file("."),
		settings = buildSettings ++ Seq(
      libraryDependencies := Seq(
        "org.scalatest" %% "scalatest" % "1.9.+" //% "test"
      ) ) )
}

