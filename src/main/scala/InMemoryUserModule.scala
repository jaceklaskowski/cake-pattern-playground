trait InMemoryUserModule extends UserModule {

  class User(val id: Long, val login: String) extends UserLike {
  }

  override def User(id: Long, login: String): User = new User(id, login)

  override def loadUser(id: Long): User = User(id, loginPrefix)

  override def loginPrefix: String = "in-memory"
}
