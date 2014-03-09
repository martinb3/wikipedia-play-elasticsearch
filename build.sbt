name := "wikipedia-play-elasticsearch"

libraryDependencies += "jline" % "jline" % "2.11"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.6.1"

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.1"

mainClass in (Compile, run) := Some("org.mbs3.rax.elasticsearch.play.Demo")

