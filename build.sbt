name := "httpz"

organization := "httpz"

version := "0.1-SNAPSHOT"

scalaVersion := "2.10.0"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0")

scalacOptions ++= Seq("-deprecation", "-unchecked")

resolvers ++= Seq(
  "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.0.0-M7",
  "org.specs2" %% "specs2" % "1.13" % "test"
)
