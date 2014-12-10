trait MySQLUserModule extends UserModule with Lifecycle {

  class User(val id: Long, val login: String) extends UserLike {
  }
  override def loginPrefix: String = "mysql"

  override def User(id: Long, login: String): User = new User(id,login)

  abstract override def startup() {
    super.startup()
    println("startin' up")
  }

  abstract override def shutdown(): Unit = {
    println("shutin' down")
    super.shutdown()
  }

  override def loadUser(id: Long): User = User(id,loginPrefix)
}
