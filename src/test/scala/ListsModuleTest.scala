import org.scalatest.FunSuite

class ListsModuleTest extends FunSuite {
  import ListsModule._

  test( "simple checks based on s99 example i/p o/p" ) {

    assert( last(List(1, 1, 2, 3, 5, 8)) === 8 )
    assert( penultimate(List(1, 1, 2, 3, 5, 8)) === 5 )
    assert( kth(2, List(1, 1, 2, 3, 5, 8)) === 2 )
    assert( length(List(1, 1, 2, 3, 5, 8)) === 6 )
    assert( reverse(List(1, 1, 2, 3, 5, 8)) === List(8, 5, 3, 2, 1, 1) )
    assert( isPalindrome(List(1, 2, 3, 2, 1)) )
    assert( flatten(List(List(1, 1), 2, List(3, List(5, 8)))) === List(1, 1, 2, 3, 5, 8) )
    assert( compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List('a, 'b, 'c, 'a, 'd, 'e) )
    assert( pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)) )
    assert( encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)) )
    assert( encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))
    assert( decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) ===
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
    assert( encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
    assert( duplicate(List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))
    assert( duplicateN(3, List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
    assert( drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===  List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
    assert( split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    assert( slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g))
    assert( rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===
      List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
    assert( rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===
      List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
    assert( removeAt(1, List('a, 'b, 'c, 'd)) === (List('a, 'c, 'd),'b))
    assert( insertAt('new, 1, List('a, 'b, 'c, 'd)) === List('a, 'new, 'b, 'c, 'd))
    assert( range(4, 9) === List(4, 5, 6, 7, 8, 9) )

//    println( randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)) )
//    println( lotto( 6, 49 ) )
//    println( randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)) )
//    println( combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)) )
//    println( group( List(2,2,5), List('a, 'b, 'c, 'd, 'e, 'f)) )

    assert( lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) ===
      List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)))
//    println( lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))))
  }
}
