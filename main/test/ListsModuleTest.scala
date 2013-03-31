import org.scalatest.FunSuite

/**
 *
 */
class ListsModuleTest extends FunSuite {
  import ListsModule._

  test( "simple checks based on s99 example i/p o/p" ) {

    // p01
    assert( last(List(1, 1, 2, 3, 5, 8)) === 8 )

    // p02
    assert( penultimate(List(1, 1, 2, 3, 5, 8)) === 5 )

    // p03
    assert( kth(2, List(1, 1, 2, 3, 5, 8)) === 2 )

    // p04
    assert( length(List(1, 1, 2, 3, 5, 8)) === 6 )

    // p05
    assert( reverse(List(1, 1, 2, 3, 5, 8)) === List(8, 5, 3, 2, 1, 1) )

    // p06
    assert( isPalindrome(List(1, 2, 3, 2, 1)) )

    // p07
    assert( flatten(List(List(1, 1), 2, List(3, List(5, 8)))) === List(1, 1, 2, 3, 5, 8) )

    // p08
    assert( compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List('a, 'b, 'c, 'a, 'd, 'e) )

    // p09
    assert( pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)) )

    // p10
    assert( encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)) )

    // p11
    assert( encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)))

    // p12
    assert( decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) ===
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))

    // p13
    assert( encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))

    // p14
    assert( duplicate(List('a, 'b, 'c, 'c, 'd)) ===
      List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd))

    // p15
    assert( duplicateN(3, List('a, 'b, 'c, 'c, 'd)) ===
      List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))

    // p16
    assert( drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===  List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))

    // p17
    assert( split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===
      (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    // p18
    assert( slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===
      List('d, 'e, 'f, 'g))

    // p19
    assert( rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===
      List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
    assert( rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) ===
      List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))

    // p20
    assert( removeAt(1, List('a, 'b, 'c, 'd)) === (List('a, 'c, 'd),'b))

    // p21
    assert( insertAt('new, 1, List('a, 'b, 'c, 'd)) ===
      List('a, 'new, 'b, 'c, 'd))

    // p22
    assert( range(4, 9) === List(4, 5, 6, 7, 8, 9) )

    println( randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)) )
    println( lotto( 6, 49 ) )
    println( randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)) )
    println( combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)) )

//    // p27
//    assert( lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) ===
//      List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)))
//
//    // p28
//    assert( lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) ===
//      List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n)))
  }
}
