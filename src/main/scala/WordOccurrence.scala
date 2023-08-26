import org.apache.spark.{SparkConf, SparkContext}
import org.apache.hadoop.fs.{FileSystem, Path}

object WordOccurrence extends App {
  val x = "C:\\ScalaIp\\TextFile\\harpers_ASCII.txt"
  val r = "C:\\ScalaOp\\WordOccurence\\harpers_ASCII_Count"
  val conf = new SparkConf().setAppName("SparkCount").setMaster("local")
  val sc =  new SparkContext(conf)

  var op = new Path(r)
  val fs = FileSystem.get(sc.hadoopConfiguration)
  if (fs.exists(op))
    fs.delete(op, true)

  val y = sc.textFile(x).cache()
  val c = y.flatMap(l => l.split(" "))
            .map(w=>(w,1))
            .reduceByKey(_ + _)
  c.saveAsTextFile(r)
  sc.stop()

}