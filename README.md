# A [Giter8][g8]/[SBT][sbt]/[Scala][scala] template 

Inspired by the [DevInsideYou g8](https://github.com/DevInsideYou/scala-seed.g8).

Typical SBT project for a TOIL spike.

It should be a cross compiling project supporting
- JVM and JS
- scala 2.12 and 2.13

## Used dependencies

No special dependencies used for the template. Most important is the giter8 sbt plugin: sbt-giter8. 
The templated project has a lot of predefined dependencies and plugins, use it or throw it away.

Plugins:
- sbt-rewarn
- sbt-updates
- sbt-revolver
- sbt-tpolecat
- sbt-git
- sbt-scalafmt
- sbt-native-packager
- sbt-scoverage
- sbt-release
- sbt-scalajs
- sbt-scalajs-crossproject
- sbt-scalajs-bundler
- sbt-kubeyml
- sbt-javaagent
- aether-deploy

Not every plugin by far is configured to be used.

Libraries:
- circe
- pureconfig
- zio
- cats
- refined
- squants
- newtype
- enumeratum
- quicklens
- monocle
- chimney
- betterMonadicFor
- kindProjector
- logback
- scalatest, scalacheck, ziotest, testcontainers

Take a look into the Dependencies.scala

## General

The template consists of 2 modules:
- core
- tests

## Testing

The template is tested with openjdk 11, graalvm community java 11.0.9 / 20.3.0

To run it just do:

    sbt new mbelikov/toil-spike.g8

[g8]: http://www.foundweekends.org/giter8/
[sbt]: https://www.scala-sbt.org/
[scala]: https://www.scala-lang.org/