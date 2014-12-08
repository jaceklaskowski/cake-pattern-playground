trait H2UserModule extends UserModule {
  class User(val id: Long, val login: String) extends UserLike {
    override def loginPrefix: String = "h2"
    override def load(id: Long): User = new User(id, login)
  }
  def User(id: Long, login: String): User = new User(id, login)
}
