
package kata


object Successive {
	def areSuccessive( a :String, b :String ) = 
	  ( a.size == b.size ) && ( a.toList.zip( b.toList ).filter( p => p._1 != p._2 ).size == 1 )
	  

	def addSuccessivePairsToMap( w1 :String, w2 :String, m :Map[String,List[String]] ) = 
	  m ++ 
	  	Map(w1 -> ( m.getOrElse(w1, List()) :+ w2 ) ) ++ 
	  	Map(w2 -> ( m.getOrElse(w2, List()) :+ w1 ) )

	  	
	def buildMap( words :List[String ] ) = {
	  def r( mapSoFar :Map[String,List[String]], remainingWords :List[String] ) :Map[String,List[String]] = {
		remainingWords match { 
		  case Nil => 
		    mapSoFar
		  case w :: ws =>
		    val matches = ws.filter( areSuccessive( _, w ) )
		    val nextMap = matches.foldLeft(mapSoFar){ case(m,other) =>
		      	addSuccessivePairsToMap(w, other, m)
		    }
		    r( nextMap, ws)
		}
	  }
	    
	  r( Map(), words )
	}
	
	def groupBySize( lines :List[String] ) = lines.groupBy( _.size ) 
}
