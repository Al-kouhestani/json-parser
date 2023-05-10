package models

package models


import controllers.{Image, Network}
import play.api.libs.json.{Json, OFormat}





final case class Rating(average: Option[Double])

  object Rating {

    implicit lazy val format: OFormat[Rating] = Json.format
  }




final case class ParsedInfo(id :Option[Int],
                            url: Option[String],
                            name: Option[String],
                            `type`: Option[String],
                            language:Option[ String],
                            status :Option[String],
                            averageRuntime: Option[Double],
                            premiered: Option[String],
                            rating: Rating,
                            network:Network ,
                            image: Image,
                            summary: Option[String]
                           )

object ParsedInfo {

  implicit lazy val formats: OFormat[ParsedInfo] = Json.format[ParsedInfo]

}