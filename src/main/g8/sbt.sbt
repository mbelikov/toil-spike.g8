import Util._

ThisBuild / organization := "$organization;format="lower,package"$"

ThisBuild / credentials += Credentials(Path.userHome / ".sbt" / ".credentials")
ThisBuild / credentials ++= ToilCredentials.createCredentials().toSeq

ThisBuild / publishTo := {
  val nexus = "https://$toilNexus;format="lower,package"$/nexus/"
  if (isSnapshot.value) Some("toil-publish-snapshots" at nexus + "repository/maven-snapshots")
  else Some("toil-publish-releases" at nexus + "repository/maven-releases")
}

Global / concurrentRestrictions := Seq(
  Tags.limit(Tags.CPU, 4),
  Tags.limit(Tags.Network, 10),
  Tags.limit(Tags.Disk, 10),
  Tags.limit(Tags.Clean, 4),
  Tags.limit(Tags.Compile, 4),
  Tags.limit(Tags.Test, 4),
  Tags.limit(Tags.Publish, 4),
  Tags.limit(Tags.Update, 4),
  Tags.limitAll(15)
)

Global / onChangedBuildSource := ReloadOnSourceChanges

Global / excludeLintKeys ++= Set(
  autoStartServer,
  turbo,
  evictionWarningOptions
)

Test / parallelExecution := false
Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oSD")
Test / turbo := true

ThisBuild / autoStartServer := false
ThisBuild / includePluginResolvers := true
ThisBuild / turbo := true
ThisBuild / useSuperShell := false

ThisBuild / watchBeforeCommand := Watch.clearScreen
ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger
ThisBuild / watchForceTriggerOnAnyChange := true

ThisBuild / shellPrompt := { state =>
  s"\${prompt(projectName(state))}> "
}
ThisBuild / watchStartMessage := {
  case (iteration, ProjectRef(build, projectName), commands) =>
    Some {
      s"""|~\${commands.map(styled).mkString(";")}
          |Monitoring source files for \${prompt(projectName)}...""".stripMargin
    }
}
