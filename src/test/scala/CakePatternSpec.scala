import org.specs2._

class CakePatternSpec extends Specification { def is = s2"""

  This is a specification to check (understanding of) the Cake Pattern

  The 'Cake Pattern'-ized universe should
    return user with 'h2' login                   $e1
    return user with 'mysql' login                $eC
    return user with 'in-memory' login            $e2
    return user with 'mysql' login                $eDHM
    return user with 'in-memory+doNothing' login  $eDDN
    return user with 'in-memory+h2' login         $eCDMH
    ${ "Hello world" must have size 11 }
                                             """

  val universe = new H2UserModule {}

  val universeC = new H2UserModuleC

  def e1 = universe.loadUser(1).login must_== "h2"
  def eC = universeC.loadUser(1).login must_== "mysql"
  def e2 = new InMemoryUserModule {}.loadUser(1).login must_== "in-memory"
  def eDHM = (new H2UserModule with AppendingUserModule).loadUser(1).login must_== "h2+appending"
  def eDDN = (new DoNothingUserModule with AppendingUserModule).loadUser(1).login must_== "doNothing+appending"
  def eCDMH = (new DependentInMemoryUserModule with AppendingUserModule ).loadUser(1).login must_== "doNothing+appending"
}
