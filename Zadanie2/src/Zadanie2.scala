object Zadanie2 extends App {
  println("--1--")
  def func1(day: String) = day match {
    case "poniedzialek" | "wtorek" | "sroda" | "czwartek" | "piatek"=> "praca"
    case "sobota" | "niedziela" => "weekend"
    case default => "Nie ma takiego dnia"
  }

  println(func1("poniedzialek"))
  println(func1("sobota"))
  println(func1("sroda to taki maly piatek"))

  println("--2--")
  var stanKonta = new KontoBankowe();
  stanKonta.wplata(200);
  stanKonta.pokazStanKonta();
  stanKonta.wyplata(100);
  stanKonta.pokazStanKonta();

  var stanKonta1 = new KontoBankowe(200)
  stanKonta1.pokazStanKonta();

  println("--3--")
  def func2(person: Person): String = {
    person match {
      case Person(name, lastName) if name.contains("piotrek") && lastName.contains("nazwisko1") =>
        "siemka byku"
      case Person(name, lastName) if name.contains("jarek") && lastName.contains("nazwisko2") =>
        "eloszka waraiacie"
      case Person(name, lastName) if name.contains("maciek") && lastName.contains("nazwisko3") =>
        "witam pana serdecznie"
      case default =>
        "hej"
    }
  }

  println(func2(new Person("piotrek", "nazwisko1")))
  println(func2(new Person("jarek", "nazwisko2")))
  println(func2(new Person("maciek", "nazwisko3")))
  println(func2(new Person("jakis random", "nazwisko4")))

  println("--4--")
  def func3(f: Int => Int, a: Int): Int = f(f(f(a)))
  println(func3(x => x+x, 12));

  println("--5--")

  val n = new Osoba("Test", "Test") with Nauczyciel
  val p = new Osoba("Test", "Test") with Pracownik
  val s = new Osoba("Test", "Test") with Student

  val sn = new Osoba("Test", "Test") with Student with Nauczyciel
  val sp = new Osoba("Test", "Test") with Student with Pracownik
  val ps = new Osoba("Test", "Test") with Pracownik with Student

  println("Nauczyciel: " + n.Podatek + "%")
  println("Pracownik: " + p.Podatek + "%")
  println("Student: " + s.Podatek + "%")

  println("Student nauczyciel: " + sn.Podatek + "%")
  println("Student pracownik: " + sp.Podatek + "%")
  println("Pracownik student: " + ps.Podatek + "%")

}

class KontoBankowe{
  def this (stan: Int) {
    this();
    this.stanKonta = stan;
  }

  private var stanKonta = 0;

  def wplata(amount: Int): Unit = {
    stanKonta += amount;
  }

  def wyplata(amount: Int): Unit = {
    stanKonta -= amount;
  }

  def pokazStanKonta(){
    println(stanKonta)
  }
}

//3
case class Person(name: String, lastName: String) {

}


//5
abstract class Osoba (private var Imie: String, private var Nazwisko: String){
  def Podatek: Int
}

trait Nauczyciel extends Pracownik {
  override val Podatek: Int = 10
}

trait Pracownik extends Osoba {
   private var Pensja :Int = _
   override def Podatek :Int = 20

  def setPensja: Int = Pensja
  def getPensja(x: Int): Unit = Pensja = x
}

trait Student extends Osoba {
  override def Podatek :Int = 0
}
