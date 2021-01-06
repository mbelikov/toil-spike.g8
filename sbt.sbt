import Util._

ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger
ThisBuild / watchForceTriggerOnAnyChange := true
ThisBuild / shellPrompt := { state =>
  s"${prompt(projectName(state))}> "
}

Global / excludeLintKeys ++= Set(
  autoStartServer
)

resolvers ++= Seq(
  Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns),
  Resolver.url("bintray-sbt-plugins", url("https://dl.bintray.com/sbt/sbt-plugin-releases"))(Resolver.ivyStylePatterns),
  Resolver.typesafeIvyRepo("releases"),
  Resolver.bintrayIvyRepo("com.eed3si9n", "sbt-plugins"),
  DefaultMavenRepository
)
