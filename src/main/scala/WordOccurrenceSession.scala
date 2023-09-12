import org.apache.spark.sql._
import org.apache.hadoop.fs.{FileSystem, Path}
import org.apache.spark.api.java.JavaRDD.fromRDD
import org.apache.spark.rdd.RDD


object WordOccurrenceSession extends App {
  val x = "C:\\ScalaIp\\TextFile\\harpers_ASCII.txt"
  val r = "C:\\ScalaOp\\WordOccurence\\harpers_ASCII_Count"
  val spark = SparkSession.builder().appName("SparkCount").master("local").getOrCreate()

  var op = new Path(r)
  val fs = FileSystem.get(spark.sparkContext.hadoopConfiguration)
  if (fs.exists(op))
    fs.delete(op, true)

  val df = spark.read.textFile(x).persist()
  val c = df.rdd.flatMap(l => l.split(" "))
    .map(w => (w, 1))
    .reduceByKey(_ + _)
  c.saveAsTextFile(r)
}