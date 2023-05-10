package controllers


import play.api.libs.json.{Json, OFormat}

final case class Network(id: Option[Int], name: Option[String], country: Country, officialSite: Option[String])

object Network {

  implicit lazy val format: OFormat[Network] = Json.format
}
