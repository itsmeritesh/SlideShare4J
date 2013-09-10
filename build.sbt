name := "SlideShare4J"

organization := "com.taroid"

version := "0.0.1"

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

libraryDependencies ++= Seq(
    "junit" % "junit" % "4.11" % "test",
    "org.mockito" % "mockito-core" % "1.9.5" % "test",
    "org.powermock" % "powermock-api-mockito" % "1.5.1" % "test",
    "org.powermock" % "powermock-module-junit4" % "1.5.1" % "test",
    "com.novocode" % "junit-interface" % "0.10-M2" % "test->default"
)
