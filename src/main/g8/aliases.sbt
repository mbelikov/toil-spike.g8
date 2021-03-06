import Util._

addCommandAlias("l", "projects")
addCommandAlias("ll", "projects")
addCommandAlias("ls", "projects")
addCommandAlias("cd", "project")
addCommandAlias("root", "cd $name;format="norm"$")
addCommandAlias("c", "+ compile")
addCommandAlias("ca", "+ test:compile")
addCommandAlias("t", "+ test")
addCommandAlias("prepare", "+clean; fix; fmt; ca; t; doc")
addCommandAlias("fmt", "all root/scalafmtSbt root/scalafmtAll")
addCommandAlias("fix", "all compile:scalafix test:scalafix; all scalafmtSbt scalafmtAll")
addCommandAlias("publishAll", "aetherDeploy")
addCommandAlias(
  "up2date",
  "reload plugins; dependencyUpdates; reload return; dependencyUpdates"
)

onLoadMessage +=
  s"""|
      |───────────────────────────────
      |    List of defined \${styled("aliases")}
      |────────────┬──────────────────
      |\${styled("l")} | \${styled("ll")} | \${styled("ls")} │ list projects / modules
      |\${styled("cd")}          │ project
      |\${styled("root")}        │ cd $name;format="norm"$
      |\${styled("c")}           │ compile
      |\${styled("ca")}          │ compile all
      |\${styled("t")}           │ test
      |\${styled("prepare")}     │ prepare the code before pushing it
      |\${styled("up2date")}     │ dependencyUpdates
      |────────────┴──────────────────""".stripMargin
