//importar bcrypt cifrar y comparar contraseñas
const bcrypt = require("bcrypt");
// importar jsonwebtoken para crear  tokens jwt
const jwt = require("jsonwebtoken");

//importar el pool de PostgreSQL
const pool = require("../config/db");

//Expresion regular basica para validar correos
const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

//validar los datos recibidos en el modulo registro
function validateRegisterInput(name, email, password){
    if(!name || !name.trim()) return "El nombre es obligatorio";
    
    if (!email || !email.trim()) return "Correo es obligatorio";

    if (!emailRegex.test(email)) return "Ingrese un correo valido";

    if (!password) return "La contraseña es obligatoria";

    if (password.length < 6) return "La contraseña debe tener al menos 6 caracteres";

    // si no hay errores retorne null
    return null;
}

function validateLoginInput(email, password){
    if (!email || !email.trim()) return "El correo es obligatorio";

    if (!password) return "La contraseña es obligatoria";

    return null;   
}

function createToken(user){
    return jwt.sign(
        {
            sub: user.id,
            name: user.name,
            email: user.email
        },

        process.env.JWT_SECRET,
        //time de expiracion del token
        {expiresIn: process.env.JWT_SECRET_IN || "10m"}
    );
}

// controlador para POST /auth/register

async function register(req, res){
    try{
        const{name, email, password} = req.body;
        const validationError = validateRegisterInput(name, email, password);
        if (validationError) {
            return res.status(400).json({message: validationError});
        }
        
        // normalizar el correo quitando espacios y convertir a minusculas
        const normalizedEmail = email.trim().toLowerCase();

        //consulta si ya existe un usuario con ese correo
        const existingUser = await pool.query(
            "SELECT id FROM Users WHERE email = $1", 
            [normalizedEmail]
        );
        if (existingUser.rowCount > 0) {
            return res.status(400).json({message: "El correo ya esta registrado"});
        }

        //cifrar la contraseña
        const passwordHash = await bcrypt.hash(password, 10);

        //insertar el usuario en PostgreSQL
        await pool.query(
            "INSERT INTO Users (name, email, password_hash) VALUES ($1, $2, $3)",
            [name.trim(), normalizedEmail, passwordHash]
        );
        res.status(200).json({message: "Usuario registrado exitosamente"});
    } catch (error) {
        console.error("Error en register:", error);
        return res.status(500).json({message: "Ocurrio un error inesperado"});
    }
}

module.exports = {
    register
}