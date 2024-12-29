package common
import com.typesafe.config._
class MyConfig{
  val config: Config = ConfigFactory.load()
  def getDataInputPath: String = {
    config.getString("testDataPath")
  }
}