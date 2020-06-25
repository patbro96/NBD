printjson(db.nbd.aggregate( {$unwind: "$credit"}, { $group: { _id: "$credit.currency", suma: {$sum: "$credit.balance"} } } ).toArray())

