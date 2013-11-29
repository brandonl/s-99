import scala.annotation.tailrec

object ArithmeticModule {

  def ints( i: Int ): Stream[Int] = i #:: ints( i + 1 )
  def primes( p: Stream[Int] = ints(2) ): Stream[Int] = p.head #:: primes( p.tail filter { _ % p.head != 0 } )

  implicit class RichArithmetics( val n: Int ) extends AnyVal {
    def isPrime: Boolean =
    if( n <= 1 ) false
    else {
        val nums = (2 to n) takeWhile { i => i*i <= n }
        nums forall { n % _ != 0 }
      }

    def isCoprimeTo( c: Int ): Boolean = {
      gcd( n, c ) == 1
    }

    def toTotient: Int = {
      (1 to n ) count ( _.isCoprimeTo( n ) )
    }

    def primeFactors: Seq[Int] = {
      @tailrec
      def factorize( res: Int, xs: Vector[Int], primes: Stream[Int] ): Seq[Int] =
        if( res.isPrime ) xs :+ res
        else if( res == 1 ) xs
        else if( res % primes.head == 0 ) factorize( res / primes.head, xs :+ primes.head, primes )
        else factorize( res, xs, primes.tail )
      factorize( n, Vector.empty, primes() )
    }

    def primeFactorMultiplicity: Map[Int, Int] = {
      @tailrec
      def loop( xs: Seq[Int], acc: Map[Int, Int] ): Map[Int, Int] = xs match {
        case Nil => acc
        case _ =>
          val (matches, rest) = xs partition { _ == xs.head }
          loop( rest, acc updated (matches.head, matches.size) )
      }
      loop( n.primeFactors, Map.empty )
    }

    def goldbach: (Int, Int) = {
      primes().takeWhile( _ < n )
              .find( i => ( n - i ).isPrime ) match {
        case None => throw new RuntimeException
        case Some(p) => (p, n - p)
      }
    }
  }

  def gcd( a: Int, b: Int ): Int = {
    var a1 = a
    var b1 = b
    while( b1 != 0 ) {
      val tmp = b1
      b1 = a1 % b1
      a1 = tmp
    }
    a1
  }

  def phi( n: Int ): Int = {
    ( 1 /: n.primeFactorMultiplicity.toList ) { (c, e) =>
      val (p, m) = e
      c * ( (p - 1) * Math.pow( p, m - 1 ).toInt )
    }
  }

  def listPrimesinRange( range: Range ): List[Int] =
    ( primes() dropWhile { _ != range.start } takeWhile { _ <= range.end } ).toList

  def printGoldbachList( range: Range ) {
//    range filter { i => i > 2 && i % 2 == 0 } foreach { i =>
//      val (p1, p2) = i.goldbach
//      println( s"$i = $p1 + $p2" )
//    }
    printGoldbachListLimited( range, 0 )
  }

  def printGoldbachListLimited( range: Range, n: Int ) {
    range filter { i => i > 2 && i % 2 == 0 } foreach { i =>
      val (p1, p2) = i.goldbach
      if( p1 >= n && p2 >= n ) println( s"$i = $p1 + $p2" )
    }
  }
}