trait AppendingUserModule extends UserModule {

  abstract override def loginPrefix = super.loginPrefix + "+appending"

}
