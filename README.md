# SGSSI-20.Lab04.1.3
## Enunciado
Crear un programa que, tomando como entrada dos ficheros de texto, devuelve como salida un aviso de correcto/incorrecto (true/false), señalando si el segundo de los ficheros cumple los siguiente requisitos:
Comienza exactamente por los mismos contenidos que el primero
1. Incluye a continuación una línea adicional con una secuencia de 8 caracteres en hexadecimal (se utilizará la representación en minúsculas de las letras a-z).
2. El resumen MD5 del fichero debe comenzar por el carácter hexadecimal “0”

## Instalacción
Para utilizar este programa se necesita un programa para Java, ya sea Eclipse, IntelliJ... En resumidas cuentas, un programa que pueda ejecutar un IDE Java. Tambíen se puede utilizar el Powershell de Windows o el bash de Linux. 

## Ejecución
Una vez descargado se abre el proyecto mediante dicho programa. Antes de ejecutarlo, hay que introducir los archivos en la carpeta del proyecto.

Se abre la única clase que hay "Principal" y se ven dos comentarios al lado de unas líneas de código, ahí se modifica el nombre del primer fichero a comparar y del segundo fichero (al cual se le añade el valor hexadecimal y se genera el digest en MD5).

Tras ajustar estos parámetros, se ejecuta el programa, y en la consola escribirá **True** si el segundo fichero es igual al primero y su digest MD5 comienza por un 0; o **False** en caso de que no se cumplan estas condiciones.

## Uso de SHA-256
Para generar el digest mediante SHA-256 solo hay que modificar la primera línea del método "digestEmpezandoPor0s", donde pone MD5 cambiarlo y escribir SHA-256.

## Licencia
Este programa está protegido bajo la licencia "GPL-3.0 License".
