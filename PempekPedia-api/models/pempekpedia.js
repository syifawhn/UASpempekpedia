const mongoose = require('mongoose')

const pempekpediaSchema = mongoose.Schema({
    nama_restoran:{
        type: String,
        required : true
    },
    tentang_restoran:{
        type: String,
        required : true
    },
    lokasi_restoran:{
        type: String,
        required : true
    },
    rating_restoran:{
        type: String,
        required : true
    },
    link_foto:{
        type: String,
        required : true
    },
    jam_operasional:{
        type: String,
        required : true
    },
    telphone:{
        type: String,
        required : true
    },

}, {
    versionkey: false
})

module.exports = mongoose.model('pempekpedia',pempekpediaSchema,'pempekpedia');