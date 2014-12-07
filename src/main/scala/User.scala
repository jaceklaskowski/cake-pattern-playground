case class User(id: Long, login: String)

trait UserModule {
  val loginPrefix: String
  def loadUser(id: Long): User
}

trait DoNothingUserModule extends UserModule {

  override val loginPrefix: String = "doNothing"

  def loadUser(id: Long): User = User(id, loginPrefix)
}

trait H2UserModule extends UserModule {

  override val loginPrefix: String = "h2"

  override def loadUser(id: Long): User = User(id, loginPrefix)
}

trait MySQLUserModule extends UserModule {

  override val loginPrefix: String = "mysql"

  override def loadUser(id: Long): User = User(id, loginPrefix)
}

trait InMemoryUserModule extends UserModule {

  override val loginPrefix: String = "in-memory"

  override def loadUser(id: Long): User = User(id, loginPrefix)
}

trait DependentInMemoryUserModule extends DoNothingUserModule {
  override def loadUser(id: Long): User = User(id, "in-memory+" + super.loadUser(id).login)
}

class H2UserModuleC extends MySQLUserModule

class DependentInMemoryUserModuleC extends DoNothingUserModule
