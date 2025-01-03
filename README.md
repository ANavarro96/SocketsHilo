# SocketsHilo
Proyecto de ejemplo en IntelliJ IDEA que implementa una comunicación sencilla entre un cliente y un servidor (multihilo) utilizando Sockets TCP.
En este proyecto el servidor es capaz de atender simultáneamente las conexiones de varios clientes gracias al uso de los hilos.
El proyecto está organizado en dos módulos principales: ejemploCliente y ejemploServidor.

# Estructura del Proyecto
El proyecto contiene las siguientes carpetas principales:

**ejemploCliente**: Contiene el código del cliente que se conecta al servidor y envía mensajes.

**ejemploServidor**: Contiene el código del servidor que espera conexiones de los clientes y procesa los mensajes.
En este caso hay dos ficheros .java:
+ **Servidor**: Implementa el socket servidor, aceptando las conexiones de los clientes y delegando dicha conexión a un hilo.
+ **ClienteConectado**: Representa cada conexión de un cliente.Implementa la interfaz Runnable y permite la comunicación concurrente del servidor con varios clientes.


**jars**: Contiene los archivos .jar compilados del cliente y el servidor, para facilitar su ejecución desde la terminal. (java -jar cliente.jar || java -jar servidor.jar)
