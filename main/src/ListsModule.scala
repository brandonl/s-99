import collection.{GenTraversableOnce, GenTraversable}
import util.Random

/**
 * First 28 s99 questions, pertaining to lists.
 */
object ListsModule {
  def ??? : Nothing = throw new Error("an implementation is missing")


	def last[T]( xs: List[T] ) = xs.last

	def penultimate[T]( xs: List[T] ) = xs.init.last

	def kth[T]( k: Int, xs: List[T] ): T =
  		if( k >= 0 ) xs(k)
  		else throw new Error()

	def length[T]( xs: List[T] ) = xs.length

	def reverse[T]( xs: List[T] ) = xs.reverse

	def isPalindrome[T]( xs: List[T] ) = xs == xs.reverse

	def flatten[T]( xs: List[T] ): List[Any] = xs flatMap {
  		case xs: List[_] => flatten(xs)
  		case x => List(x)
  }

  def compress[T]( xs: List[T] ): List[T] =
    xs.foldRight( List[T]() ){ (hd, tl) => if( tl.isEmpty || hd != tl.head ) hd::tl else tl }

  def pack[T]( xs: List[T] ): List[List[T]] = xs match {
    case Nil => Nil
    case y::_ =>
      val (zs, rest) = xs.span( _ == y )
      zs :: pack( rest )
  }

  def encode[T]( xs: List[T] ): List[(Int, T)] =
    pack( xs ).map{ x => (x.length, x.head) }
//      xs match {
//      case Nil => Nil
//      case y::_ =>
//        val (zs, rest) = xs.span( _ == y )
//        (zs.size, zs.head) :: encode( rest )
//    }

  def encodeModified[T]( xs: List[T] ): List[Any] =
    pack( xs ).map{ x => if( x.length == 1 ) x.head else (x.length, x.head) }


  def decode[T]( xs: List[(Int, T)] ): List[T] =
    xs.flatMap{ case (len, ele) => List.fill( len )( ele ) }

  def encodeDirect[T]( xs: List[T] ): List[(Int, T)] = xs match {
    case Nil => Nil
    case y::_ =>
      val (zs, rest) = xs.span( _ == y )
      (zs.length, zs.head) :: encodeDirect( rest )
  }

  def duplicate[T]( xs: List[T] ): List[T] =
    xs.flatMap{ x => List( x, x ) }

  def duplicateN[T]( n: Int, xs: List[T] ): List[T] =
    xs.flatMap { x => List.fill( n )( x ) }

  def drop[T]( n: Int, xs: List[T] ): List[T] =
    if( xs.isEmpty ) Nil
    else xs.slice( 0, n-1 ) ++ drop( n, xs.slice( n, xs.length ) )

  def split[T]( n: Int, xs: List[T] ): (List[T], List[T]) =
    xs.splitAt( n )

  def slice[T]( from: Int, until: Int, xs: List[T] ): List[T] =
    xs.drop( from ).take( until - ( from max 0 ) )

  def rotate[T]( n: Int, xs: List[T] ): List[T] =
    if( n >= 0 ) ( xs drop n ) ++ ( xs take n )
    else ( xs drop ( xs.length - -n ) ) ++ ( xs take ( xs.length - -n ) )

  def removeAt[T]( n: Int, xs: List[T] ): (List[T], T) = {
    val (l, r) = xs.splitAt(n)
    ( ( l ++ r.tail ), xs(n) )
  }


  def insertAt[T]( item: T, n: Int, xs: List[T] ): List[T] = {
    val (l, r) = xs.splitAt(n)
    l ++ List(item) ++ r
  }

  def range( start: Int, end: Int ): List[Int] =
    ( start to end ).toList

  def randomSelect[T]( n: Int, xs: List[T] ): List[T] = {
    @annotation.tailrec
    def loop( n: Int, xs: List[T], acc: List[T] ): List[T] = {
      if( n > 0 ) {
        val (lst, ele) = removeAt( Random.nextInt( xs.size ), xs )
        loop( n-1, lst, ele :: acc )
      }
      else acc
    }
    loop( n, xs, Nil )
  }

  def lotto( n: Int, m: Int ): List[Int] =
    randomSelect( n, range( 1, m ) )

  def randomPermute[T]( xs: List[T] ): List[T] =
    randomSelect( xs.size, xs )

  // From s-99 site:
  // The canonical way to shuffle imperatively is Fisher-Yates.  It requires a
  // mutable array.  This is O(n).
  //  def randomPermute[A](ls: List[A]): List[A] = {
  //    val a = ls.toArray
  //    for (i <- a.length - 1 to 1 by -1) {
  //      val i1 = Random.nextInt(i + 1)
  //      a.update(i, a(i1))
  //      a.update(i1, t)
  //      val t = a(i)
  //    }
  //    a.toList
  //  }

  def combinations[T]( n: Int, xs: List[T] ): List[List[T]] = ???

  def group3[T]( xs: List[T] ): List[List[List[T]]] = ???

  def lsort[T]( xs: List[T] ): List[List[T]] = ???

  def lostFreq[T]( xs: List[T] ): List[List[T]] = ???
}