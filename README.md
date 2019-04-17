# Trabajo Practico FRESCAS - Laboratorio V TP 1 UTN
Para ejecutar -> Agregar a la base de datos una columna "raza".
# ¿ Que es MAVEN ?
Maven es un framework de administración de proyectos; en otras palabras, una herramienta que automatiza el proceso de construcción de un proyecto Java.
Provee un conjunto de estándares de construcción, un modelo de repositorio de artefactos y un motor de software que administra y describe los proyectos. Por ejemplo, teniendo en cuenta la naturaleza interdependiente de proyectos open source, Maven permite normalizar ubicaciones para los archivos fuente, documentación y archivos binarios, para proveer una plantilla común para la documentación de proyecto y recuperar dependencias de proyecto de un repositorio compartido, de tal forma que el proceso de construcción consume menos tiempo y es mucho más transparente.

# POM: ¿Que significa?¿Para que nos sirve?
En primer lugar, pom, responde a las siglas de Project Object Model, es un fichero que contiene datos de configuración de nuestro proyecto, como dependencias con otros jar, tipos de informes que queremos en la página web de nuestro proyecto, etc.. Inicialmente contiene una serie de cosas por defecto que podremos cambiar si lo deseamos.

# Diferencia entre Archetype y ArficatId
- **Archetype**: un arquetipo es un patrón o modelo sobre el que se pueden desarrollar todas aquellas tareas que son de un mismo tipo. Puede decirse que son plantillas, parametrizadas o configuradas para utilizar determinadas tecnologías que los desarrolladores utilizan como base para escribir y organizar el código de la aplicación.
- **ArficatId**: es el nombre que queramos dar al proyecto. Maven creará un directorio con este nombre y el jar que genere para el proyecto tendrá también este nombre. Todos los proyectos maven tienen un nombre para identificarlos, que se denomirá artifactId.

# Goals: [clean,package,install,compile]
Goal es un comando que recibe maven como parámetro para que haga algo. La sintaxis sería:

```
mvn plugin:comando
```
- **clean:**  Limpia todas las clases compiladas del proyecto.
- **package:** Empaqueta el proyecto (si es un proyecto java simple, genera un jar, si es un proyecto web, un war, etc…).
- **install:** Instala el artefacto en el repositorio local.
- **compile:** Compila el proyecto.

# Scopes: [compile,provide,runtime,test,system]
El scope sirve para indicar el alcance de nuestra dependencia y su transitividad.
- **compile:** Es la que tenemos por defecto sino especificamos scope. Indica que la dependencia es necesaria para compilar. La dependencia además se propaga en los proyectos dependientes.
- **provide:** Es como la anterior, pero esperas que el contenedor ya tenga esa libreria. Un claro ejemplo es cuando desplegamos en un servidor de aplicaciones, que por defecto, tiene bastantes librerías que utilizaremos en el proyecto, así que no necesitamos desplegar la dependencia.
-  **runtime:** La dependencia es necesaria en tiempo de ejecución pero no es necesaria para compilar.
-  **test:** La dependencia es solo para testing que es una de las fases de compilación con maven. JUnit es un claro ejemplo de esto.
- **system:** Es como provided pero tienes que incluir la dependencia explicitamente. Maven no buscará este artefacto en tu repositorio local. Habrá que especificar la ruta de la dependencia mediante la etiqueta <systemPath>
