name := "SlideShare4J"

organization := "com.taroid"

version := "0.0.1"

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

libraryDependencies ++= Seq(
    "junit" % "junit" % "4.11" % "test",
    "org.mockito" % "mockito-core" % "1.9.5" % "test",
    "com.novocode" % "junit-interface" % "0.8" % "test->default"
)
