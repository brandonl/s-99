object ListsModule 
{
	def p01[T]( xs: List[T] ) = xs.last
	def p02[T]( xs: List[T] ) = xs.init.last
	def p03[T]( k: Int, xs: List[T] ): T =
  		if( k >= 0 ) xs(k)
  		else throw new Error()
	def p04[T]( xs: List[T] ) = xs.length
	def p05[T]( xs: List[T] ) = xs.reverse
	def p06[T]( xs: List[T] ) = xs == xs.reverse
	def p07[T]( xs: List[T] ): List[Any] = xs flatMap {
  		case xs: List[_] => p07(xs)
  		case x => List(x)
  	}
	def p08[T]( xs: List[T] ): List[T] =
 		xs.foldRight( List[T]() ){ ( h, t ) => if( t.isEmpty || h != t.head ) h :: t else t }
}