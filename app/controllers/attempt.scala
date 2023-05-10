package controllers



import models.models.ParsedInfo
import play.api.libs.Files.logger
import play.api.libs.json.{JsResult, Json}
import sun.net.www.protocol.http.HttpURLConnection

import java.net.URL
import scala.io.Source
import scala.util.Try

object attempt extends App{
  val fileName = "tv_show_urls.txt"
  val urlList: List[String] = Source.fromFile(fileName).getLines.toList



  @throws(classOf[java.io.IOException])
  @throws(classOf[java.net.SocketTimeoutException])
  def get(url: String,
          connectTimeout: Int = 5000,
          readTimeout: Int = 5000,
          requestMethod: String = "GET"): Try[Seq[ParsedInfo]] = {

 Try {
      val connection = (new URL(url)).openConnection.asInstanceOf[HttpURLConnection]
      connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11")
      connection.setConnectTimeout(connectTimeout)
      connection.setReadTimeout(readTimeout)
      connection.setRequestMethod(requestMethod)
      val inputStream = connection.getInputStream
      val content = Source.fromInputStream(inputStream).mkString
      if (inputStream != null) inputStream.close()
      val json = Json.parse(content)
      val caseClasses = json.as[Seq[ParsedInfo]]
      caseClasses
    }
    }


  val responses = urlList.foreach(url =>
      println(get(url))
  )
/*
def fileContainsQuestion(file: File): Boolean = {
  val source = Source.fromFile(file)

  try {
    source.getLines().toSeq.headOption.map { line =>
      line.trim.endsWith("?")
    }.getOrElse(false)
  } finally source.close()
}
 */
}

