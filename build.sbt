ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

val sparkVersion = "3.4.1"


lazy val root = (project in file("."))
  .settings(
    name := "SparkExample",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkVersion
    )
  )
