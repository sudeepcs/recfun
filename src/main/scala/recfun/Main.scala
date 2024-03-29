package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1 else (pascal(c - 1, r -1) + pascal(c, r-1))
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
		  
    def balanceHelp(nest: Int, remChars: List[Char]): Boolean = {
      if (remChars.isEmpty || nest < 0) nest==0 
      else if (remChars.head == '(') balanceHelp(nest + 1, remChars.tail)
      else if (remChars.head == ')') balanceHelp(nest - 1, remChars.tail)
      else balanceHelp(nest, remChars.tail)
    }
    balanceHelp(0, chars)
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
