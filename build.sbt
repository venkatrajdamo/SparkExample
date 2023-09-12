ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.17"

val sparkVersion = "3.4.1"

lazy val root = (project in file("."))
  .settings(
    name := "SparkExample",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkVersion,
      "org.apache.spark" %% "spark-sql" % sparkVersion
    ),
    Compile / resourceDirectory := baseDirectory.value / "src/resources",
    Runtime / resourceDirectory := baseDirectory.value / "src/resources"
  )
