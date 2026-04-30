function cargarUsuarios(){
    // console.log("Voy a cargar los usuarios...")
    const response = await fetch("http://localhost:8080/users") // GET 1s
    const usuarios = await response.json()
    usuarios.forEach(user => {
        // Creo un DIV nuevo y lo meto dentro del DIV id = usuarios
        const card = document.createElement("div");
    });

}