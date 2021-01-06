import Dependencies._

lazy val scala213               = "2.13.4"
lazy val scala212               = "2.12.12"
lazy val supportedScalaVersions = List(scala212, scala213)

ThisBuild / scalaVersion := scala213

lazy val root = (project in file("."))
  .settings(name := "$name$")
  .settings(commonSettings)
  .aggregate(core.js, core.jvm, tests.js, tests.jvm)
  .settings(crossScalaVersions := Nil) // crossScalaVersions must be set to Nil on the aggregating project
  .settings(publish / skip := true)
  .settings(publishArtifact := false) // skip aether deployment/publishing)
//  .settings(coverageJvm / aggregate := false)

lazy val core = (crossProject(JSPlatform, JVMPlatform) in file("modules/core"))
  .settings(name := "$name$-core")
  .settings(commonSettings)
  .settings(Defaults.itSettings)
  .settings(makeBatScripts := Seq())
  .settings(sharedDependencies)
  .jsSettings(coverageEnabled := false)
  .jsSettings(scalaJSUseMainModuleInitializer := false)

lazy val tests = (crossProject(JSPlatform, JVMPlatform) in file("modules/tests"))
  .configs(IntegrationTest)
  .settings(name := "$name$-test-suite")
  .settings(commonSettings)
  .settings(Defaults.itSettings)
  .settings(sharedDependencies)
  .settings(testDependencies)
  .settings(testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-u", "modules/tests/target/junit-report"))
  .jsSettings(coverageEnabled := false)
  .jvmSettings(coverageEnabled := true)
  .dependsOn(core)

lazy val commonSettings = Seq(
  libraryDependencies ++= Seq(
        compilerPlugin(Libraries.kindProjector cross CrossVersion.full),
        compilerPlugin(Libraries.betterMonadicFor)
      ),
  crossScalaVersions := supportedScalaVersions,
  scalafmtOnCompile := true,
  semanticdbEnabled := true, // enable SemanticDB
  semanticdbOptions += "-P:semanticdb:synthetics:on",
  semanticdbVersion := scalafixSemanticdb.revision, // use Scalafix compatible version
  ThisBuild / scalafixScalaBinaryVersion := CrossVersion.binaryScalaVersion(scalaVersion.value),
  ThisBuild / scalafixDependencies ++= List(
        "com.github.liancheng" %% "organize-imports" % "0.4.4",
        "com.github.vovapolu"  %% "scaluzzi"         % "0.1.16"
      )
  //    scalacOptions += "-Ymacro-annotations",   // scala 2.13 only, how???
//  update / evictionWarningOptions := EvictionWarningOptions.empty,
//  Compile / console / scalacOptions := {
//    (Compile / console / scalacOptions)
//      .value
//      .filterNot(_.contains("wartremover"))
//      .filterNot(Scalac.Lint.toSet)
//      .filterNot(Scalac.FatalWarnings.toSet) :+ "-Wconf:any:silent"
//  },
)

// main dependencies
lazy val sharedDependencies = Seq(
  libraryDependencies ++= Seq(
        Libraries.refinedCore,
        Libraries.newtype
      )
)

lazy val jvmDependencies = Seq(
  libraryDependencies ++= Seq()
)

lazy val jsDependencies = Seq(
  libraryDependencies ++= Seq()
)

lazy val testDependencies = Seq(
  libraryDependencies ++= Seq(
        Libraries.scalaCheck,
        Libraries.scalaTest,
        Libraries.scalaTestPlus
      )
)
