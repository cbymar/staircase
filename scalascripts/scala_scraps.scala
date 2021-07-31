val s1 = "ten"
val s2 = "t" + "en"
s1 == s2
val s3 = null
val a = "chris"
val b = "Chris"
a.equalsIgnoreCase(b)

a.replaceAll("i","e")

"hello chris".split(" ").foreach(println)

val s = "eggs, milk, butter, Lucky Charms"
s.split(",").map(_.trim)

// use the raw"" interpolator to prevent \n to newlines.


val upper = "hello, world".map(c => c.toUpper) // same as:
val upper = "hello, world".map(_.toUpper)

"HELLO".map( c => (c.toByte + 32).toChar)
"HELLO".map{ c =>
	(c.toByte + 32).toChar
}

// use brackets for multiline map function

package tests

object Adler32Checksum {

	val MOD_ADLER = 65521

	def main(args: Array[String]): Unit = {
		val sum = adler32sum("Wikipedia")
		printf("checksum (int) = %d\n", sum)
		printf("checksum (int) = %d\n", sum.toHexString)
	}

	def adler32sum(s: String): Int = {
		var a = 1
		var b = 0
		s.getBytes.foreach{ char =>
			a = (char + a) % MOD_ADLER
			b = (b + a) % MOD_ADLER
		}
		b * 65536 + a
	}
}

// how to use this?? 
// scala error: type mismatch; found   : String("hi") required: Array[String]

// 1.6 regex
val numPattern = "[0-9]+".r
val address = "123 Main Street Suite 101"
val match1 = numPattern.findFirstIn(address)
val matches = numPattern.findAllIn(address) // returns an iterator

// can also use 
val matches = numPattern.findAllIn(address).toArray
val matches = numPattern.findAllIn(address).toSeq
val matches = numPattern.findAllIn(address).toList
val matches = numPattern.findAllIn(address).toVector

// optionally, use 
import scala.util.matching.Regex
val numPattern = new Regex("[0-9]+")

match1 match {
	case Some(s) => println(s"found: $s")
	case None =>
}
// does not work
matches match {
	case Some(s) => println(s"found: $s")
	case None =>
}

match1.foreach { e =>
	println(s"Found a match: $e")
}

matches.foreach { e =>
	println(s"Found a match: $e")
}

val address = "123 Main Street suite 410".replaceAll("[0-9]", "x")

val regex = "[0-9]".r
val address = regex.replaceAllIn("123 Main Street suite 410","x")

val regex = "H".r
regex.replaceFirstIn("Hello, world!", "J")

val pattern = "([0-9]+) ([A-Za-z]+)".r

val pattern(count, fruit) = "100 Bananas"

textUserTyped match {
	case MoviesZipRE(zip) => getSearchResults(zip)
	case MoviesNearCityStateRE(city, state) => getSearchResults(city, state) // passing tuple to function
	case _ => println("did not match any of our regexes")
}


"Chris"(2)

// implicit class

implicit class StringImprovements(s: String) {
	def increment = s.map(c => (c+1).toChar)
}

val result = "HAL".increment


package com.chrismartin.utils
object StringUtils {
	implicit class StringImprovements(s: String) {
		def increment = s.map(c => (c+1).toChar)
	}	
}


package foo.bar
import com.chrismartin.utils.StringUtils._
object Main extends App {
	println("HAL".increment)
}

// What exactly (and why) implicit class?

// Dates
libraryDependencies += "com.github.nscala-time" %% "nscala-time" % "2.28.0"
load.ivy("com.github.nscala-time" %% "nscala-time" % "2.28.0")
load.ivy("com.lihaoyi" %% "scalatags" % "0.4.5")
import com.github.nscala_time.time.Imports._
DateTime.now

Seq.fill(10)(Seq.fill(3)("Foo"))

import $cp.`import com.github.nscala_time.time.Imports._`







class Point {
  private var _x = 0 // vars
  private var _y = 0
  private val bound = 100 // val

  def x = _x
  def x_ = (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
    }

  def y = _y
  def y_= (newValue: Int): Unit = {
  if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: oob")
}









