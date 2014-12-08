trait MySQLUserModule extends UserModule with Lifecycle {

  override def User(id: Long, login: String): User = ???

  abstract override def startup() {
    super.startup()
    println("startin' up")
  }

  abstract override def shutdown(): Unit = {
    println("shutin' down")
    super.shutdown()
  }
}
