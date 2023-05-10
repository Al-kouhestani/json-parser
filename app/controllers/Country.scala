package controllers

import play.api.libs.json.{Json, OFormat}

final case class Country(name: Option[String], code: Option[String], timezone : Option[String] )

object Country {

  implicit lazy val format: OFormat[Country] = Json.format
}