const express = require("express");

//importar el controlador que devuelve el perfil de autenticacion
const {getMe} = require("../controllers/userController");

//importar el middleware que valida el token JWT
const authMiddleware = require("../middlewares/authMiddleware");

//crear un router, para rutas relacionadas con usuario
const router = express.Router();

//definir la ruta del perfil de autenticacion
router.get("/me", authMiddleware, getMe);

module.exports = router;