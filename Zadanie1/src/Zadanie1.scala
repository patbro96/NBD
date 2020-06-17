object Zadanie1 extends App {
  val list = List("poniedzialek", "wtorek", "sroda", "czwartek", "piatek", "sobota", "niedziela")
  println("--ZAD1--")
  println("--a--")
  val wynik = new StringBuilder();
  for (day <- list) {
    if(day == "niedziela"){
      wynik.insert(wynik.size, day);
    }else {
      wynik.insert(wynik.size, day + ", ");
    }
  }
  println(wynik.toString())

  println("--b--")
  val wynik2 = new StringBuilder();
  for (day <- list if day.startsWith("p")){
      wynik2.insert(wynik2.size, day + ", ");
    }
  println(wynik2.toString())


  println("--c--")
  val wynik3 = new StringBuilder();
  var i = 0;
  while (i < list.length) {
    if(list(i) == "niedziela"){
      wynik3.insert(wynik3.size, list(i));
    }else {
      wynik3.insert(wynik3.size, list(i) + ", ");
    }
    i += 1
  }
  println(wynik3.toString())

  println("--ZAD2--")
  println("--a--")

  val wynik4 = new StringBuilder();
  def fact(list: List[String]): String=
  {
    if(list.isEmpty) ""
    else {
      if(list.head == "niedziela"){
        wynik4.insert(wynik4.size, list.head)
      }
      else {
        wynik4.insert(wynik4.size, list.head + ",")
      }
      list.head + fact(list.tail)
    }
  }
  fact(list);
  println(wynik4)

  println("--b--")
  def fact2(list:List[String]):String={
    if (list.tail.isEmpty){ list.head}
    else fact2(list.tail) + ", " + list.head
  }
  println(fact2(list))



  println("--ZAD3--")
  def fact3[T](list: List[T]) {
    def tail(list: List[T], i: Int) {
        if(!list.isEmpty) {
          println(list.head)
          tail(list.tail, i + 1)
        }
    }
    tail(list, 0)
  }

  fact3(list)

  println("--ZAD4--")
  val wynik6 = new StringBuilder();

  list.fold(0) { (z, i) =>
    if(i == "niedziela"){
      wynik6.insert(wynik6.size, i);
    }else {
      wynik6.insert(wynik6.size, i + ", ");
    }
  }

  println(wynik6)
  wynik6.clear();

  list.foldRight() { (z, i) =>
    if(z == "poniedzialek"){
      wynik6.insert(wynik6.size, z);
    }else {
      wynik6.insert(wynik6.size, z + ", ");
    }
  }
  println(wynik6)
  wynik6.clear();

  list.foldLeft() { (z, i) =>
    {
    if(i.startsWith("p")) {
        wynik6.insert(wynik6.size, i + ", ");
      }
    }
  }
  println(wynik6)
  wynik6.clear();

  println("--ZAD5--")
  val products = Map("produkt1" -> 2.2, "produkt2" -> 3.5, "produkt3" -> 1.1);
  val dp = products map{ case (key, value) =>( key, value * 0.90)};

  println(dp)

  println("--ZAD6--")
  val (a, b, c) = (1, "test", 1.1)
  println("a: " + a)
  println("b: " + b)
  println("c: " + c)

  println("--ZAD7--")
  def opt(z: Option[String]) = z match
  {
    case Some(s) => (s)
    case None => ("key not found")
  }

  val m = Map("a" -> "is a",
    "b" -> "is b")

  println(opt(m.get("a")))
  println(opt(m.get("b")))
  println(opt(m.get("c")))

  println("--ZAD8--")
  var listDouble =  List(100.0, 30, 0, 5, 6 ,30, 0, 100, 12, -5)

  def fanc5[Double](list : List[Double], result: List[Double] = Nil) : List[Double] =
  {
    if(!list.isEmpty) {
      if (list.head == 0){
        fanc5(list.drop(1), result)
      }
      else {
        fanc5(list.drop(1), list.head :: result)
      }
    }
    else result
  }
  println(fanc5(listDouble))

  println("--ZAD9--")
  def func6(list: List[Double]) : List[Double] =
  {
    list.map(x => x + 1);
  }

  val wynik7 = func6(listDouble)
  wynik7.foreach(println)
  println("--ZAD10--")
  def func7(list: List[Double]): List[Double] = {
    list.filter(x =>  -5 <= x && x <= 12);
  }

  val wynik8 = func7(listDouble)
  wynik8.foreach(println)
}
