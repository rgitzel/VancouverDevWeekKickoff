package specs2

import org.specs2.mutable.Specification
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner
import kata.Successive


@RunWith(classOf[JUnitRunner])
class TestSpec extends Specification{

  "successive" should {
    "work" in {
      Successive.areSuccessive( "dog", "dot" ) must beTrue
      Successive.areSuccessive( "dog", "log" ) must beTrue
      Successive.areSuccessive( "dog", "dig" ) must beTrue
    }

    "fail on different sizes" in {
      Successive.areSuccessive( "dog", "dogg" ) must beFalse
      Successive.areSuccessive( "dogg", "dog" ) must beFalse
    }
  }
  
  "addSuccessivePairsToMap" should {
    "work on empty map" in {
      val m = Map[String,List[String]]()
      
      val results = Successive.addSuccessivePairsToMap( "a", "b", m )
      
      results.size must_== 2
      results.get("a").get must_== List("b")
      results.get("b").get must_== List("a")
    }

    "work on non-empty map" in {
      val m = Map( "a" -> List("c", "d"), "b" -> List("x") )
      
      val results = Successive.addSuccessivePairsToMap( "a", "b", m )
      
      results.size must_== 2
      results.get("a").get must_== List("c", "d", "b")
      results.get("b").get must_== List("x","a")
    }
  }
  
  "buildMap" should {
    "work in a simple case" in {
    	val words = List("cat", "dog", "dig", "cad", "cod", "bat" )
    	
    	val results = Successive.buildMap(words)
    	
    	results.size must_== words.size
    	
    	results.get("cat").get must_== List("cad","bat")
    	results.get("dog").get must_== List("dig")
    	results.get("dig").get must_== List("dog")
    	results.get("cad").get must_== List("cat","cod")
    	results.get("cod").get must_== List("cad")
    	results.get("bat").get must_== List("cat")
    }
  }
  
  "groupBySize" should {
    "work!" in {
    	val words = List("c", "dog", "bb", "dd", "s", "sssss" )
    	
    	val results = Successive.groupBySize(words)
    	
    	results.size must_== 4
    	
    	results.get(1).get must_== List("c", "s")
    	results.get(2).get must_== List("bb","dd")
    	results.get(3).get must_== List("dog")
    	results.get(4) must beNone
    	results.get(5).get must_== List("sssss")
    }
  }
}