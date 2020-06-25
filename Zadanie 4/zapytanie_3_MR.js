db.nbd.mapReduce(
    function func(){
        emit(this.job, 0)
    },
    function func1(k, v)
    {

    }
    ,{
    out: "stanowiska"
    }
);

printjson(db.jobs.find().toArray())