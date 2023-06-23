const express = require('express');
const router = express.Router();
const pempekpedia = require('../models/pempekpedia');
const { ObjectId } = require('mongodb')

// Route GET untuk mendapatkan semua data restoran
router.get('/get', async (req, res) => {
  try {
    const restoran = await pempekpedia.find();
    res.json({ success: 1, message: 'restoran berhasil ditambahkan', newrestoran: restoran });
  } catch (err) {
    res.status(400).json({ success: 0, message: err.message });
  }
});

// Route GET untuk mendapatkan data restoran  berdasarkan ID
router.get('/:id', async (req, res) => {
  try {
    const restoran = await pempekpedia.findById(req.params.id);
    if (!restoran) {
      return res.status(404).json({ message: ' Data restoran tidak ditemukan' });
    }
    res.json(restoran);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// Route POST untuk membuat data restoran baru
router.post('/add', async (req, res) => {
  const restoran = new pempekpedia({
    nama_restoran   : req.body.nama_restoran,
    lokasi_restoran : req.body.lokasi_restoran,
    telphone        : req.body.telphone,
    rating_restoran : req.body.rating_restoran,
    link_foto       : req.body.link_foto,
    jam_operasional : req.body.jam_operasional,
    tentang_restoran: req.body.tentang_restoran,
    restoran_id     : req.body.restoran_id,
  });

  try {
    const newrestoran = await restoran.save();
    res.status(201).json({ message: 'Restoran berhasil ditambahkan', data: newrestoran });
  } catch (err) {
    res.status(400).json({ message: 'Gagal menambahkan restoran', error: err.message });
  }
});

// Route PUT untuk memperbarui data restoran berdasarkan ID
router.put('/update/:id', async (req, res) => {
  try {
    const restoran = await pempekpedia.findById(req.params.id);
    if (!restoran) {
      return res.status(404).json({ message: 'Data restoran tidak ditemukan' });
    }

    restoran.restoran_id = req.body.restoran_id;
    restoran.nama_restoran = req.body.nama_restoran;
    restoran.restoran = req.body.restoran;
    restoran.lokasi_restoran = req.body.lokasi_restoran;
    restoran.rating_restoran = req.body.rating_restoran;
    restoran.link_foto = req.body.link_foto;
    restoran.jam_operasional = req.body.jam_operasional;

    const updatedrestoran = await restoran.save();
    res.json({ message: 'Data restoran berhasil diperbarui', data: updatedrestoran});
  } catch (err) {
    res.status(400).json({ message: 'Gagal memperbarui data restoran', error: err.message });
  }
});

// Route DELETE untuk menghapus data restoran berdasarkan ID
router.delete('/delete/:id', async (req, res) => {
  try {
    const restoran = await pempekpedia.findByIdAndDelete(new ObjectId(req.params.id));
    if (!restoran) {
      return res.status(404).json({ succes:0, message: 'Data restoran tidak ditemukan' });
    }

    res.json({ succes: 1, message: 'Data restoran berhasil dihapus' });
  } catch (err) {
    res.status(500).json({ succes:0, message: 'Gagal menghapus data restoran', error: err.message });
  }
});

module.exports = router;