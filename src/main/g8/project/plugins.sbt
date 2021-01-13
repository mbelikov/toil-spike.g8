ThisBuild / scalaVersion := "2.12.13"
ThisBuild / useSuperShell := false
ThisBuild / autoStartServer := false

update / evictionWarningOptions := EvictionWarningOptions.empty

addSbtPlugin("com.timushev.sbt" % "sbt-rewarn"   % "0.1.2")
addSbtPlugin("com.timushev.sbt" % "sbt-updates"  % "0.5.1")
addSbtPlugin("io.spray"         % "sbt-revolver" % "0.9.1")
//addSbtPlugin("org.wartremover"  % "sbt-wartremover" % "2.4.13")

addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat"             % "0.1.16")
addSbtPlugin("com.typesafe.sbt"          % "sbt-git"                  % "1.0.0")
addSbtPlugin("org.scalameta"             % "sbt-scalafmt"             % "2.4.2")
addSbtPlugin("ch.epfl.scala"             % "sbt-scalafix"             % "0.9.24")
addSbtPlugin("com.typesafe.sbt"          % "sbt-native-packager"      % "1.8.0")
addSbtPlugin("org.scoverage"             % "sbt-scoverage"            % "1.6.1")
addSbtPlugin("com.github.gseitz"         % "sbt-release"              % "1.0.13")
addSbtPlugin("org.scala-js"              % "sbt-scalajs"              % "1.4.0")
addSbtPlugin("org.portable-scala"        % "sbt-scalajs-crossproject" % "1.0.0")
addSbtPlugin("ch.epfl.scala"             % "sbt-scalajs-bundler"      % "0.20.0") // to bundle the .js files
addSbtPlugin("org.vaslabs.kube"          % "sbt-kubeyml"              % "0.3.9")
addSbtPlugin("com.lightbend.sbt"         % "sbt-javaagent"            % "0.1.6")
addSbtPlugin("no.arktekk.sbt"            % "aether-deploy"            % "0.26.0")
