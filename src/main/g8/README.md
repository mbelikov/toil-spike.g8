# $name$
[![pipeline status](https://misp.t-systems.com/tools/gitlab/TOIL/$name$/badges/master/pipeline.svg)](https://misp.t-systems.com/tools/gitlab/TOIL/$name$/-/commits/master)
[![coverage report](https://misp.t-systems.com/tools/gitlab/TOIL/$name$/badges/master/coverage.svg)](https://misp.t-systems.com/tools/gitlab/TOIL/$name$/-/commits/master)
[![chat toil-expression-dsl](https://toil-ubuntu.westeurope.cloudapp.azure.com/api/v1/shield.svg?name=$name$)](https://toil-ubuntu.westeurope.cloudapp.azure.com/channel/$name$)

The aim of the $name$ is
- to ...
- to ...

The project is using the 'pure' scala and compiles to (2.12, 2.13) x (JVM, JS) i.e. the following 4 build artefacts are provided after the build:
- jvm
    - 2.12
    - 2.13
- js
    - 2.12
    - 2.13

# Build

    sbt +clean +compile

# Release

    sbt release