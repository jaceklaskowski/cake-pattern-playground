trait UserModule {

  type User <: UserLike

  trait UserLike { this: User =>
    def loginPrefix: String
    def id: Long
    def login: String

    def load(id: Long): User
  }

  def User(id: Long, login: String): User
}
