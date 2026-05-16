const express = require("express");
const pool = require("../config/db");

const router = express.Router();

// Ruta login
router.post("/login", (req, res) => {
    res.json({
        message: "Login funcionando"
    });
});

// Ruta register
router.post("/register", async (req, res) => {

    try {

        const { name, email, password } = req.body;

        const result = await pool.query(
            `INSERT INTO users (name, email, password_hash)
             VALUES ($1, $2, $3)
             RETURNING *`,
            [name, email, password]
        );

        res.status(201).json({
            message: "Usuario registrado",
            user: result.rows[0]
        });

    } catch (e) {

        console.error(e);

        res.status(500).json({
            message: "Error registrando usuario"
        });

    }

});

module.exports = router;