import org.specs2._

class CakePatternSpec extends Specification { def is = s2"""

  This is a specification to check (understanding of) the Cake Pattern

  The 'Cake Pattern'-ized universe should
    return user with 'h2' login                   $e1
    return user with 'mysql' login                $eC
    return user with 'in-memory' login            $e2
    return user with 'h2' login                   $e3
    return user with 'mysql' login                $eDHM
    return user with 'h2' login                   $eDH
    return user with 'h2' login...WHY not in-memory+doNothing?!  $eDHDN
    return user with 'in-memory+doNothing' login  $eDDN
    return user with 'in-memory+h2' login         $eCDMH
    ${ "Hello world" must have size 11 }
                                             """

  val universe = new H2UserModule {}

  val universeC = new H2UserModuleC

  def e1 = universe.loadUser(1).login must_== "h2"
  def eC = universeC.loadUser(1).login must_== "mysql"
  def e2 = (new H2UserModuleC with InMemoryUserModule).loadUser(1).login must_== "in-memory"
  def e3 = (new H2UserModuleC with H2UserModule).loadUser(1).login must_== "h2"
  def eDHM = (new DependentInMemoryUserModule with H2UserModule with MySQLUserModule {}).loadUser(1).login must_== "mysql"
  def eDH = (new DependentInMemoryUserModule with H2UserModule {}).loadUser(1).login must_== "h2"
  def eDHDN = (new DependentInMemoryUserModule with H2UserModule with DoNothingUserModule {}).loadUser(1).login must_== "h2"
  def eDDN = (new DependentInMemoryUserModule with DoNothingUserModule {}).loadUser(1).login must_== "in-memory+doNothing"
  def eCDMH = (new DependentInMemoryUserModuleC with DependentInMemoryUserModule).loadUser(1).login must_== "in-memory+doNothing"
}
