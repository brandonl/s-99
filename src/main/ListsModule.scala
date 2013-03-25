import collection.{GenTraversableOnce, GenTraversable}

/**
 * First 28 s99 questions, pertaining to lists.
 */
object ListsModule {

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
}