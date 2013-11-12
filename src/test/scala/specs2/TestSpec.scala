package specs2

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestSpec extends Specification{

  "foo" should {
    "bar" in {
      1 must_== 1
    }
  }
}