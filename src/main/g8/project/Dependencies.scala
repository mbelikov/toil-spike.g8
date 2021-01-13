import sbt._

object Dependencies {

  object Versions {
    val pureConfig         = "0.13.0"
    val pureConfigRefinedV = "0.9.15"

    val newtype    = "0.4.4"
    val refined    = "0.9.14"
    val skunk      = "0.0.9"
    val squants    = "1.6.0"
    val enumeratum = "1.6.1"

    val betterMonadicFor = "0.3.1"
    val kindProjector    = "0.11.2"
    val logback          = "1.2.3"

    val jodaTime    = "2.10"
    val chimney     = "0.5.2"
    val quicklens   = "1.6.1"
    val shapeless   = "2.3.3"
    val circe       = "0.13.0"
    val circeExtras = "0.13.0"
    val monocle     = "2.0.3"

    val cats        = "2.1.1"
    val catsEffect  = "2.1.3"
    val catsMeowMtl = "0.4.0"
    val catsRetry   = "1.1.0"

    val zio               = "1.0.1"
    val zioInteropVersion = "2.1.4.0"
    val zioLogging        = "0.4.0"

    val scalaCheck             = "1.15.2"
    val scalaTest              = "3.2.3"
    val containersScalaVersion = "0.38.7"
    val scalaTestPlus          = "3.2.2.0"
    val specs2                 = "4.5.1"

    val toilProtobuf      = "1.7.0-SNAPSHOT"
    val toilC8yScala      = "0.4.0-SNAPSHOT"
    val toilExpressionDsl = "0.0.5-SNAPSHOT"
  }

  object Libraries {
    private val testWithIt = "it, test"

    val circeCore          = "io.circe" %% "circe-core"           % Versions.circe
    val circeGeneric       = "io.circe" %% "circe-generic"        % Versions.circe
    val circeParser        = "io.circe" %% "circe-parser"         % Versions.circe
    val circeRefined       = "io.circe" %% "circe-refined"        % Versions.circe
    val circeGenericExtras = "io.circe" %% "circe-generic-extras" % Versions.circeExtras
    val circeShapes        = "io.circe" %% "circe-shapes"         % Versions.circe
    val circeOptics        = "io.circe" %% "circe-optics"         % Versions.circe
    val circeAll: Seq[ModuleID] =
      Seq(circeCore, circeGeneric, circeParser, circeRefined, circeGenericExtras, circeShapes, circeOptics)

    val pureconfig                   = "com.github.pureconfig" %% "pureconfig" % Versions.pureConfig
    val pureconfigRefined            = "eu.timepit" %% "refined-pureconfig" % Versions.pureConfigRefinedV
    val allPureconfig: Seq[ModuleID] = Seq(pureconfig, pureconfigRefined)

    val zio                   = "dev.zio" %% "zio" % Versions.zio
    val zioStreams            = "dev.zio" %% "zio-streams" % Versions.zio
    val zioMacros             = "dev.zio" %% "zio-macros" % Versions.zio
    val zioCatsInterop        = "dev.zio" %% "zio-interop-cats" % Versions.zioInteropVersion
    val zioLogging            = "dev.zio" %% "zio-logging" % Versions.zioLogging
    val zioLoggingSlf4j       = "dev.zio" %% "zio-logging-slf4j" % Versions.zioLogging
    val zioAll: Seq[ModuleID] = Seq(zio, zioStreams, zioMacros, zioCatsInterop, zioLogging, zioLoggingSlf4j)

    val cats       = "org.typelevel" %% "cats-core"   % Versions.cats
    val catsEffect = "org.typelevel" %% "cats-effect" % Versions.catsEffect

    val refinedCore = "eu.timepit" %% "refined"      % Versions.refined
    val refinedCats = "eu.timepit" %% "refined-cats" % Versions.refined

    val squants    = "org.typelevel"              %% "squants"    % Versions.squants
    val quicklens  = "com.softwaremill.quicklens" %% "quicklens"  % Versions.quicklens
    val newtype    = "io.estatico"                %% "newtype"    % Versions.newtype
    val chimney    = "io.scalaland"               %% "chimney"    % Versions.chimney
    val enumeratum = "com.beachape"               %% "enumeratum" % Versions.enumeratum

    // Compiler plugins
    val betterMonadicFor = "com.olegpy"    %% "better-monadic-for" % Versions.betterMonadicFor
    val kindProjector    = "org.typelevel" % "kind-projector"      % Versions.kindProjector

    // Runtime
    val logbackCore               = "ch.qos.logback" % "logback-core" % Versions.logback
    val logbackLogback            = "ch.qos.logback" % "logback-classic" % Versions.logback
    val logbackAll: Seq[ModuleID] = Seq(logbackCore, logbackLogback)

    // Test
    val scalaCheck     = "org.scalacheck"    %% "scalacheck"                     % Versions.scalaCheck
    val scalaTest      = "org.scalatest"     %% "scalatest"                      % Versions.scalaTest
    val scalaTestPlus  = "org.scalatestplus" %% "scalacheck-1-14"                % Versions.scalaTestPlus
    val zioTest        = "dev.zio"           %% "zio-test"                       % Versions.zio % testWithIt
    val zioTestSbt     = "dev.zio"           %% "zio-test-sbt"                   % Versions.zio % testWithIt
    val testContainers = "com.dimafeng"      %% "testcontainers-scala-scalatest" % Versions.containersScalaVersion % testWithIt

    val monocleCore  = "com.github.julien-truffaut" %% "monocle-core"  % Versions.monocle % testWithIt
    val monocleMacro = "com.github.julien-truffaut" %% "monocle-macro" % Versions.monocle % testWithIt

    val testAll: Seq[ModuleID] =
      Seq(scalaCheck, scalaTest, scalaTestPlus, zioTest, zioTestSbt, testContainers, monocleCore, monocleMacro)

  }
}
