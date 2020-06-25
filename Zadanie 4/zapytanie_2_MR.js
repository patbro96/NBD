db.nbd.mapReduce(
    function func(){
    this.credit.forEach(function(x) {
    emit(x.currency, x.balance);
        });
    },
    
    function func1(k, v){
        return Array.sum(v)
    },{out: "suma"}
);

printjson(db.suma.find().toArray())