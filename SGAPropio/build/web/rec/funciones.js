function validarForm(formulario) {
    
    if(formulario.name = "login_form"){
        return validarLoginForm(formulario);
    }
}

function validarLoginForm(formulario){
    //Validamos el usuario
    var usuario = formulario.username;
    if (usuario.value == "" || usuario.value == "Escribir usuario") {
        alert("Debe proporcionar un nombre de usuario");
        return false;
    }

    //Validamos el password
    var password = formulario.password;
    if (password.value == "" || password.value.length < 3) {
        alert("Debe proporcionar un password al menos de 3 caracteres");
        return false;
    }

    //Todo ha salido bien
    return true;
}