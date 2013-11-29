import scala.collection.mutable

object LogicModule {

  def not( a: Boolean ): Boolean = if( a ) false else true
  def and( a: Boolean, b: Boolean ): Boolean = (a, b) match {
    case (true, true) => true
    case _ => false
  }
  def or( a: Boolean, b: Boolean ): Boolean = (a, b) match {
    case (false, false) => false
    case _ => true
  }
  def nand( a: Boolean, b: Boolean ): Boolean = not( and( a, b) )
  def nor( a: Boolean, b: Boolean ): Boolean = not( or( a, b ) )
  def xor( a: Boolean, b: Boolean ): Boolean = and( or(a, b), nand(a, b) )
  def impl( a: Boolean, b: Boolean ): Boolean = or( not(a), b)
  def equ( a: Boolean, b: Boolean ): Boolean = and( impl(a, b), impl(b, a) )

  def table2( fn: (Boolean, Boolean) => Boolean ) {
    println( "A\tB\tResult" )
    for{
      a <- Seq(true, false)
      b <- Seq(true, false)
    } println( s"$a\t$b\t${fn(a,b)}" )
  }

  def gray( n: Int ): List[String] =
    if( n <= 0 ) Nil
    else if( n == 1 ) List( "0", "1" )
    else {
     val prev = gray( n -1 )
     ( prev map { "0" + _ } ) ++ ( prev.reverse map { "1" + _ } )
    }

  def huffman( in: List[(String, Int)] ): List[(String, String)] = {
    sealed trait Tree[T]
    case class Branch[T]( data: T, left: Tree[T], right: Tree[T] ) extends Tree[T]
    case class Leaf[T]( data: T ) extends Tree[T]

    implicit val ordering = Ordering.fromLessThan( ( left: (String, Int), right: (String, Int) ) => left._2 > right._2 )
    val pq = mutable.PriorityQueue[(String, Int)]()
    pq ++= in

    def buildHuffmanTree( root: Tree[Set[String]] ): Tree[Set[String]] = {
      if( pq.isEmpty ) root
      else {
        val (ls, _) = pq.dequeue()
        root match {
          case Leaf(d) => buildHuffmanTree( Branch( d + ls, Leaf( Set(ls) ), root ) )
          case Branch( d, l, r ) => buildHuffmanTree( Branch( d + ls, Leaf( Set(ls) ), root ) )
        }
      }
    }

    buildHuffmanTree( Leaf( Set( pq.dequeue()._1 ) ) )
    Nil
  }
}
