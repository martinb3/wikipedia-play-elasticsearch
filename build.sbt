import play.Project._

name := "wikipedia-play-elasticsearch"

resolvers += "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "org.elasticsearch" % "elasticsearch" % "0.90.12"

libraryDependencies += "io.searchbox" % "jest" % "0.0.6" 

playScalaSettings
