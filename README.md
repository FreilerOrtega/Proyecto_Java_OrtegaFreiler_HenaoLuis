# Proyecto_Java_OrtegaFreiler_HenaoLuis
## Happy Feets
Este proyecto se basa en una aplicación para una veterinaria en la cual se manejan 3 usuarios principales: Cliente, Administrador, Veterinario. La aplicación permite gestionar lo que maneja la veterinaria como inventario, manejo de facturas, procedimientos, etc.

### Funciones de usuarios
***Cliente***
- **Ver historial de citas:** en este se muestran todas sus mascotas y dependiendo de la que ingrese puede ver el historial de citas de esa mascota.
- **Ver historial clínico:** Puede ver el historial de sus mascotas en el cual ve la información de su mascota, padecimientos, historial de vacunas y desparasitaciones.
- **Ver procedimientos de mascotas.**
- **Ver cirugías de mascotas.**
  
***Administrador***
- **Gestionar inventario:** Puede ver productos por reabastecer, próximos a vencer, además de agregar productos y ver todos los productos que se han registrado en el sistema.
- **Gestionar personas:** Puede añadir una nueva persona al sistema, bien sea cliente, veterinario o administrador, modificar los datos de una persona así como su usuario y contraseña para ingresar a la aplicación.
- **Gestionar factura:** Puede añadir productos a la factura de una persona con una descripción en caso de que sea necesario. Una vez se da clic en el botón de *Generar factura*, se muestra en pantalla la factura y se pide la carpeta en la que quiera guardar el PDF de la factura.
- **Gestionar contratos de adopción:** Puede generar un contrato de adopción con alguna mascota sin dueño, dar seguimiento a un contrato mediante una cita y ver el seguimiento de un contrato.
- **Gestionar mascotas:** Puede añadir mascotas al sistema en caso de que alguien haya llevado una mascota nueva o también se puede añadir una mascota para adopción. También se pueden modificar datos de las mascotas.
- **Gestionar citas:** Se puede crear una cita y cambiar el estado de una en caso de que la persona haya asistido o la haya cancelado.

***Veterinario***
- **Ver procedimientos realizados.**
- **Ver cirugías realizadas.**
- **Ver consultas realizadas.**
- **Dar diagnóstico a una cita:** En este se puede dar el diagnóstico a una cita que tenga, además de poder programar una cirugía o procedimiento. Puede detectar un padecimiento y aplicar una vacuna o desparasitación.

## Tecnologias usadas 
|Java|MySQL|
|--|--|
| [![My Skills](https://skillicons.dev/icons?i=java&theme=light)](https://skillicons.dev)| [![My Skills](https://skillicons.dev/icons?i=mysql&theme=light)](https://skillicons.dev) |

## Uso de la aplicacion
1. clona el repositorio
```sh
   git clone https://github.com/FreilerOrtega/Proyecto_Java_OrtegaFreiler_HenaoLuis
```
2. Abre el proyecto en *intellij idea*
3. Ejecuta el archivo de main que se encuentra en la ruta
```sh
./Proyecto_Java_OrtegaFreiler_HenaoLuis/src/main/java/main.java
```

## Base de datos
Esta aplicación maneja una base de datos almacenada en *Clever Cloud*. La creación de tablas, así como las inserciones básicas, se encuentran dentro de la carpeta *MySQL_Archivos*, la cual maneja la siguiente estructura:

![drawSQL-image-export-2025-03-30](https://github.com/user-attachments/assets/c61c1466-f91c-4d49-814f-e3626db4ced5)

https://drawsql.app/teams/lucho-2/diagrams/happyfeets/embed

## Creditos
*Freiler Ortega*, *Luis Henao*
