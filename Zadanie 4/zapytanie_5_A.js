printjson(db.nbd.aggregate({
    $unwind: "$credit"
}, {
    $match: {
        "nationality": "Poland",
        "sex": "Female"
    }
}, {
    $group: {
        _id: "$credit.currency",
        suma: {
            $sum: {
                $toDouble: "$credit.balance"
            }
            },
            srednia: {
            $avg: {
                $toDouble: "$credit.balance"
            }
        }
    }
}).toArray())