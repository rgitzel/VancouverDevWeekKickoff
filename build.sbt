
organization := "rgitzel"

name := "dev-week-kickoff"

scalaVersion := "2.10.2"
 
version := "0.1-SNAPSHOT"

libraryDependencies ++= Seq(
	"org.specs2" %% "specs2" % "2.3.3" % "test",
	"com.novocode" % "junit-interface" % "0.9" % "test"
)

resolvers ++= Seq(
    )

