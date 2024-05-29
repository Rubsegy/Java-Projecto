**ES:**Español
# Proyecto de Conexión de Objetos a Base de Datos en Java

Este proyecto está basado en un trabajo asignado para finalizar una Unidad Formativa de Programación Orientada a Objetos de Java, que consiste en la conexión de Objetos a la Base de Datos.

## Mi programa consiste en lo siguiente:
Basado en un Menú que contiene las siguientes opciones:
- Nuevo Vehículo
- Eliminar Vehículo
- Buscar Matrícula
- Modificar Información
- Importar Datos
- Exportar Datos
- Salir

## Descripción de las funciones:
- **Nuevo Vehículo**: Añade un vehículo con sus atributos del menú y, a partir de ahí, recorre el Array para realizar un `hasNext`, crear otro vehículo y registrarlo en la base de datos.
- **Eliminar Vehículo**: A partir de la matrícula y número de bastidor, busca en la base de datos en la tabla `vehiculos` y recorre el Array para realizar un `remove`.
- **Buscar Matrícula**: A partir de la matrícula, filtra todos los atributos que coincidan con el método `equals` del vehículo que coincidan con la matrícula.
- **Modificar Información**: A partir de la base de datos, comprueba si el vehículo existe y obliga a actualizar sus campos.
- **Importar Datos**: A partir de una nueva tabla en SQL, importa los archivos y los guarda en la tabla SQL.
- **Exportar Datos**: Al presionar el botón, realiza una exportación de la tabla `vehiculos.sql` y guarda el archivo en descargas.

**EN:**English

# Object to Database Connection Project in Java

This project is based on an assignment to complete a Training Unit in Object-Oriented Programming in Java, which involves connecting Objects to a Database.

## My program consists of the following:
Based on a Menu that contains the following options:
- New Vehicle
- Delete Vehicle
- Search License Plate
- Modify Information
- Import Data
- Export Data
- Exit

## Function Descriptions:
- **New Vehicle**: Adds a vehicle with its attributes from the menu and, from there, iterates through the Array to perform a `hasNext`, create another vehicle, and register it in the database.
- **Delete Vehicle**: Based on the license plate and chassis number, searches the database in the `vehicles` table and iterates through the Array to perform a `remove`.
- **Search License Plate**: Based on the license plate, filters all attributes that match the vehicle's `equals` method that correspond to the license plate.
- **Modify Information**: From the database, checks if the vehicle exists and forces its fields to be updated.
- **Import Data**: From a new table in SQL, imports the files and saves them in the SQL table.
- **Export Data**: When the button is pressed, exports the `vehicles.sql` table and saves the file in downloads.
