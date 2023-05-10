package controllers

import play.api.libs.json.{Json, OFormat}

final case class Image(medium: Option[String], original: Option[String])

object Image {

  implicit lazy val format: OFormat[Image] = Json.format
}