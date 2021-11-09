function valida_envia(){
   	//valido el nombre
   	if (document.fvalida.nombreBuscar.value.trim().length==0){
      		alert("Escriba un nombre para buscar")
      		document.fvalida.nombreBuscar.focus()
      		return false;
   	}
   	
}