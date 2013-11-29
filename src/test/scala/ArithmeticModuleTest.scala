import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class ArithmeticModuleTest extends WordSpec with ShouldMatchers {
  import ArithmeticModule._

  "" in {
    7.isPrime should equal (true)
    1.isPrime should equal (false)
    10.isPrime should equal (false)

    gcd(1, 4) should equal (1)
    gcd(10, 4) should equal (2)
    gcd(3, 5) should equal (1)
    gcd(30, 50) should equal (10)

    35.isCoprimeTo(64) should equal (true)
    10.isCoprimeTo(15) should equal (false)

    10.toTotient should equal (4)
    1.toTotient should equal (1)

    315.primeFactors should equal (Seq(3, 3, 5, 7))
    1.primeFactors should equal (Seq())

    315.primeFactorMultiplicity should equal (Map(3 -> 2, 5 -> 1, 7 -> 1))

    phi( 10 ) should equal (4)
    phi( 1 ) should equal (1)

    listPrimesinRange( 7 to 31 ) should equal (List(7, 11, 13, 17, 19, 23, 29, 31))

    28.goldbach should equal ((5,23))

    printGoldbachList(9 to 20)
    printGoldbachListLimited(1 to 2000, 50)
  }
}
