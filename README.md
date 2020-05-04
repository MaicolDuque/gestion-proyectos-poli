# gestion-proyectos-poli
<h1>API Rest para gestion de proyectos.</h1>
<strong>URL deploy:</strong> https://gestion-proyectos-jic.herokuapp.com/ <br>
<strong>URL Documentación API:</strong> https://gestion-proyectos-jic.herokuapp.com/api/swagger-ui.html<br>

Crear grupo basico
localhost:9080/api/group
{
	"nombre":"gr-1",
	"descripcion":"asd"
}


Crear grupo basico
localhost:9080/api/folder
{
	"nombre":"gr-1",
	"descripcion":"asd",
	"group":{
			"id":1
	}
}

Crear archivo

localhost:9080/api/folder/4
key file adjunta el archivo.