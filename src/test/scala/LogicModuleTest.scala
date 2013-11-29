import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec

class LogicModuleTest extends WordSpec with ShouldMatchers {
  import LogicModule._

  "" in {
    LogicModule.not( true ) should equal (false)
    LogicModule.not( false ) should equal (true)

    and( true, true ) should equal (true)
    and( true, false ) should equal (false)

    nand( true, true ) should equal (false)
    nand( true, false ) should equal (true)

    or( true, true ) should equal (true)
    or( true, false ) should equal (true)
    or( false, false ) should equal (false)

    nor( true, true ) should equal (false)
    nor( false, false ) should equal (true)

    table2((a: Boolean, b: Boolean) => and(a, or(a, b)))

    gray(3) should equal (List("000", "001", "011", "010", "110", "111", "101", "100"))

    huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
  }
}
