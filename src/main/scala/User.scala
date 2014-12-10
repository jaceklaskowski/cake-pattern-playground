trait UserModule {

  type User <: UserLike

  trait UserLike {
    this: User =>
    def id: Long

    def login: String

  }

  def User(id: Long, login: String): User

  def loadUser(id: Long): User

  def loginPrefix: String

}
