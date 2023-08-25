import org.apache.spark.{SparkConf, SparkContext}

object SampleExample extends App {
  val x = "D:\\Raj\\repos\\Data\\TextFile\\harpers_ASCII.txt"
  val r = "D:\\Raj\\repos\\Data\\TextFile\\harpers_ASCII_Count"
  val conf = new SparkConf().setAppName("SparkCount").setMaster("local")
  val sc =  new SparkContext(conf)
  val y = sc.textFile(x).cache()
  val c = y.flatMap(l => l.split(" "))
            .map(w=>(w,1))
            .reduceByKey(_ + _)
  c.saveAsTextFile(r)
  sc.stop()

}