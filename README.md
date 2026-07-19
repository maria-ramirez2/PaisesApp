# Países App

Aplicación móvil para Android que presenta un directorio de países y permite agregar nuevos elementos y crear una lista personalizada de favoritos.

## Descripción

Países App muestra una lista inicial de países mediante una interfaz desarrollada con Jetpack Compose. El usuario puede incorporar nuevos países al directorio, consultar una indicación de detalles y seleccionar aquellos que desea guardar como favoritos.

La aplicación permite alternar entre el directorio completo y la lista de países favoritos.

## Funcionalidades

- Visualización de una lista inicial de países.
- Presentación eficiente de elementos mediante `LazyColumn`.
- Incorporación de nuevos países.
- Validación para evitar entradas vacías.
- Selección de países como favoritos.
- Prevención de elementos duplicados en favoritos.
- Vista independiente para los países favoritos.
- Cambio entre la lista general y la lista de favoritos.
- Presentación de mensajes mediante `Toast`.
- Interfaz basada en Material Design 3.

## Países incluidos

La lista inicial contiene los siguientes países:

- Panamá
- México
- Argentina
- Chile
- Colombia
- España
- Italia
- Francia
- Japón
- Brasil
- Canadá
- Alemania
- Portugal
- Corea del Sur

El usuario puede agregar otros países durante la ejecución de la aplicación.

## Tecnologías utilizadas

- Kotlin
- Android Studio
- Jetpack Compose
- Material Design 3
- AndroidX
- Gradle con Kotlin DSL
- Java 11

## Funcionamiento

La pantalla principal muestra un directorio de países. Cada país aparece dentro de una tarjeta con las opciones **Detalles** y **Favorito**.

El usuario también puede escribir el nombre de otro país en el campo de texto y presionar **Agregar** para incorporarlo al directorio.

Al seleccionar **Favorito**, el país se añade a una lista independiente. El botón ubicado en la barra superior permite alternar entre las siguientes vistas:

- Directorio de países.
- Países favoritos.

## Administración del estado

Las listas de países y favoritos se administran mediante `mutableStateListOf`. Esto permite actualizar automáticamente la interfaz cuando se agrega un país o se modifica la lista de favoritos.

El estado que determina la vista seleccionada se controla mediante `remember` y `mutableStateOf`.

Los datos se conservan durante la ejecución actual de la aplicación, pero no se almacenan permanentemente al cerrarla.

## Interfaz

La interfaz incluye:

- Barra superior con título dinámico.
- Botón para cambiar entre las vistas.
- Campo para introducir un país.
- Botón para agregar elementos.
- Lista desplazable.
- Tarjetas individuales para cada país.
- Botones de detalles y favoritos.
- Diseño con color turquesa y tipografía serif.

## Estructura principal

### `MainActivity.kt`

Inicializa la aplicación y establece la interfaz de Jetpack Compose.

### `MainApp`

Administra:

- La lista general de países.
- La lista de favoritos.
- El cambio entre las vistas.
- La barra superior.
- La presentación de las listas.

### `CountryInput`

Componente responsable de:

- Capturar el nombre de un país.
- Administrar el contenido del campo.
- Agregar el país a la lista.
- Limpiar el campo después de la operación.

### `CountryCard`

Componente reutilizable que muestra:

- El nombre del país.
- La opción de consultar detalles.
- El botón para agregar el país a favoritos.

## Requisitos

- Android Studio.
- Java 11 o una versión compatible.
- Android SDK 24 o superior.
- Emulador o dispositivo Android.

Versiones configuradas:

- SDK mínimo: 24
- SDK objetivo: 36
- SDK de compilación: 36

## Instalación y ejecución

1. Descargar el proyecto.
2. Abrir la carpeta `PaisesApp` en Android Studio.
3. Esperar la sincronización de Gradle.
4. Seleccionar un emulador o dispositivo Android.
5. Presionar **Run** para ejecutar la aplicación.

## Instrucciones de uso

1. Abrir la aplicación.
2. Explorar el directorio inicial.
3. Escribir otro país y presionar **Agregar**.
4. Presionar **Favorito** para guardar un país en la lista correspondiente.
5. Presionar **Ver Favoritos** para consultar los países seleccionados.
6. Presionar **Ver Todos** para regresar al directorio completo.
7. Utilizar **Detalles** para mostrar el nombre del país seleccionado.

## Aprendizajes obtenidos

Este proyecto permite practicar:

- Creación de interfaces con Jetpack Compose.
- Manejo de listas dinámicas.
- Uso de `LazyColumn`.
- Administración de estados.
- Creación de componentes reutilizables.
- Validación de entradas.
- Manejo de eventos.
- Diseño con Material Design 3.
- Presentación de notificaciones mediante `Toast`.

## Estado del proyecto

Proyecto académico funcional desarrollado como práctica de programación móvil.

## Autora

María
