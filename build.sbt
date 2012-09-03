name := "httpz"

organization := "httpz"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.0-M7"

crossScalaVersions := Seq("2.9.1", "2.9.2")

scalacOptions ++= Seq("-deprecation", "-unchecked")

resolvers ++= Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scalaz" % "scalaz-core_2.10.0-M7" % "7.0.0-M3",
  "org.specs2" % "specs2_2.10.0-M7" % "1.12.1.1" % "test"
)
