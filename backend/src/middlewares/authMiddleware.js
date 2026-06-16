//importar Jsonwebtoken para validar tokens JWT
const jwt = require("jsonwebtoken")

//Middleware ->protege rutas privadas
function authMiddleware(req, res, next){
    //leer el header de autorizacion de la peticion
    const authorization = req.headers.authorization;

    //valida que el header exista y tenga un formato bearer
    if(!authorization || !authorization.startsWith("Bearer")){
        return res.status(401).json({message: "Token no proporcionado"})
    }

    //extraer solo el token
    const token = authorization.split(" ")[1];

    try{
        //verificar que el token sea valido, usndo el secreto JWT
        const payload = jwt.verify(token, process.env.JWT_SECRET);
        req.user =  {
            id: payload.sub,
            email: payload.email
        };
        //permite seguir hacia el controllador final
        return next();
    } catch (error){
        return res.status(401).json({message: "Token invalido o expirado"});
    }
}

module.exports = authMiddleware;
