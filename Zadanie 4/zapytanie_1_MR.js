db.nbd.mapReduce( 
    function func() { 
        emit(this.sex, {wzrost: this.height, waga: this.weight}) 
    }, 
function func1(k, v) { 
    var wynik = {wzrost: 0, waga: 0} 
    var licznik = 0
    v.forEach(
    function func2(i) { 
        wynik.wzrost += i.wzrost; 
        wynik.waga += i.waga; 
        licznik++;
    }
    ); 
    wynik.wzrost = wynik.wzrost / licznik, 
    wynik.waga = wynik.waga / licznik 
    return wynik 
}, 
    { out: "srednia"}); 

printjson(db.srednia.find().toArray())