# Marvel's Champs

Se solicita la creación de la estructura de una app que muestre un listado de los
personajes Marvel y permite ver el detalle de cada uno de ellos de manera
individual. No me he centrado mucho en la interfaz de la app, entiendo que se van a evaluar mis capacidades técnicas.

## Requisitos 📋

    ● Requerido usar Xcode/Android Studio.
    ● Requerido utilizar Swift/Kotlin
    ● Se puede hacer uso de frameworks y librerías de terceros.
    ● No usar SwiftUI en iOS para la implementación de la capa de vista.
    ● Se valorará la implementación de tests.
    ● Se valorará un correcto control de errores.
    ● Total libertad para añadir cualquier funcionalidad extra que se considere

## ¿Por qué utilizo...? 🔧

### MVVM y Clean Architecture

He utilizado la arquitectura MVVM y Clean Architecture (Presentación, casos de uso, domain, data, framework). También podría haber separado el detalle del campeón en un modulo,
 ya que a partir de ahora, GooglePlay no acepta apk, solo Bundle App.  

### Ramas

La principal para la prueba es la rama "master", pero hay otras 2 ramas por si se quieren revisar. Una es "detail_petition", hace otra petición para recoger los detalles
de un campeón, ya que en la rama "master" utilizo los datos recogidos en la petición donde se recogen todos los campeones. Otra rama es "bbdd" donde he intentado utilizar
una base de datos, pero me he quedado sin tiempo, esta a medio hacer.

###  Librerías

He intentado utilizar todo con lo que he trabajdo hasta ahora:

    ● Injección de dependencias con Hilt (Dagger)
    ● Retrofit para las peticiónes. Aunque en mi actual empresa estoy trabajando con Volley. Se trabajar con las 2
    ● ViewModel y Livedata obviamente para poder trabajar con MVVM
    ● Room como capa de abstracción para la base de datos (Como he comentado anteriormente, en la rama "bbdd" se puede ver)
    ● Navigation de Android Jetpack que permite implementar la navegación
    ● Sin test 
    ● Internacionalización de textos