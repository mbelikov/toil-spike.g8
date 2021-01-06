import sbt._

object ToilCredentials {
  val toilNexusRealm = "Sonatype Nexus Repository Manager"
  val toilNexusHost = "$toilNexusHost;format="lower,word"$"
  val uidProp = "nexus_username"
  val pwdProp = "nexus_password"

  def credentialsFromUserHome(): Credentials = {
    Credentials(Path.userHome / ".sbt" / ".credentials")
  }
  def credentialsFromEnvironmentVars(): Option[Credentials] = {
    val nexusUidNexusPwdMaybe = Option(System.getenv().get(uidProp)) match {
      case None if System.getProperty(uidProp) != null =>
        println(s"nexus username (sys props): \${System.getProperty(uidProp)}")
        Some((System.getProperty(uidProp), System.getProperty(pwdProp)))
      case Some(_) =>
        println(s"nexus username (env props): \${System.getenv().get(uidProp)}")
        Some((System.getenv().get(uidProp), System.getenv().get(pwdProp)))
      case _ =>
        None
    }

    nexusUidNexusPwdMaybe
      .map(nexusUidNexusPwd => Credentials(toilNexusRealm, toilNexusHost, nexusUidNexusPwd._1, nexusUidNexusPwd._2))
  }

  def createCredentials(): List[Credentials] = {
    credentialsFromUserHome() :: credentialsFromEnvironmentVars().toList
  }
}
