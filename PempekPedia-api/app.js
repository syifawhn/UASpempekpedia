const express = require('express')
const app = express()
const mongoose = require('mongoose')
const bodyParser = require('body-parser')
const cors = require('cors')
require('dotenv/config')

app.use(bodyParser.urlencoded({extended: true}))
app.use(cors())
app.use(bodyParser.json())

const routes = require('./routes/pempekpedia')

app.use('/api', routes)

app.get('/', (req, res) => {
  res.send('Hello World!')
})

mongoose.connect(process.env.DB_CONNECTION,{
    useNewUrlParser: true,
    useUnifiedTopology: true
})

let db = mongoose.connection

//handle error
db.on('error', console.error.bind(console, ' Tidak terhubung ke Data base?'))

//handle success
db.once('open', () => {
  console.log('Terhubung ke Data base')
})

app.listen(process.env.PORT, () => {
  console.log(`Server sedang berjalan ${process.env.PORT}`)
})