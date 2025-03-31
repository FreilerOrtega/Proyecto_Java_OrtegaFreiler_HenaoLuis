# Proyecto_Java_OrtegaFreiler_Henaoluis
## Happy Feets
Este proyecto se basa en un aplicacion para una veterinaria en la cual se manejan 3 usuarios principales: Cliente, Administrador, Veterinario. La aplicacion permite gestionar lo que maneja la veterinaria como inventario, manejo de facturas, procedimientos, etc.

### Funciones de usuarios
***Cliente***
- **Ver historial de citas:** en este se muestran todas sus mascotas y dependiendo la que ingrese puede ver el historial de citas de esa mascota.
- **Ver historial clinico:** Puede ver el historial de sus mascotas en el cual ve la informacion de su mascotas, padecimientos, historial de vacunas y desparacitaciones.
- **Ver procedimientos de mascotas.**
- **Ver cirugias de mascotas.**
  
***Administrador***
- **Gestionar inventario:** Puede ver productos por reabastecer, proximo a vencer, ademas de agregar productos y ver todos los productos que se han registrado en el sistema
- **Gestionar personas:** Puede añadir una nueva persona al sistema, bien sea cliente, veterinario o administrador modificar los datos de una persona asi como su usuario y contraseña para ingresar a la aplicacion
- **Gestionar factura:** Puede añadir productos a la factura de una persona y con descripcion en el caso de que sea necesario, una ves se da clic en el boton de Generar factura se muestra en pantalla la factura y se pide la carpeta en la que quiera guardar el pdf de la factura.
- **Gestionar contratos de adopcion:** En este puede Generar un contrato de adopcion con alguna mascota sin dueño, dar seguimiento a un contrato mediante una cita y ver el seguimiento de de un contrato
- **Gestionar mascotas:** En este puede añadir mascotas al sistema en caso de que alguien haya llevado una mascota nueva o tambien se puede añadir una mascota para adopcion y tambien se puden modificar datos de las mascotas
- **Gestionar citas:** Se puede crear una cita y cambiar el estado de una en caso de que la persona haya asistido o la haya cancelado

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
Esta aplicacion maneja una base de datos almacenadas en *Clever Cloud*. La creacion de tablas asi como las inserciones basicas se encuentarn dentro de la carpeta MySQL_Archivos, la cual maneja la siguiente estructura

![drawSQL-image-export-2025-03-30](https://github.com/user-attachments/assets/c61c1466-f91c-4d49-814f-e3626db4ced5)

https://drawsql.app/teams/lucho-2/diagrams/happyfeets/embed

## Creditos
*Freiler Ortega*, *Luis Henao*
