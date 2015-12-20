# ProgramaMe

Soluciones de los ejercicios planteados en
[ProgramaMe](http://www.programa-me.com/) y
[aceptaelreto.com](https://www.aceptaelreto.com/) planteadas por los alumnos y
profesores del IES Gaspar Melchor de Jovellanos de Fuenlabrada (Madrid)

## Estructura del directorio

Cada ejercicio se guarda en un directorio aparte donde se indique el número del
problema con tres dígitos, un guión y un título descriptivo del problema sin
espacios. Por ejemplo:

```
141-ParentesisBalanceados
```

Los directorios que finalizan con el sufijo NR (**N**o **R**esueltos) almacenan
problemas cuya solución aún no ha sido aceptada por el juez virtual.

En cada directorio encontramos tres ficheros:

- El enunciado del problema en un fichero con extensión ``.pdf``
- La resolución del problema en un fichero con extensión ``.java``
- Un ejemplo de entrada en el fichero ``sample.in``


## Como colaborar

Para poder subir código a este repositorio lo primero que debes tener es una
[cuenta en GitHub](https://github.com/join) e instalarte
[Git](https://git-scm.com/downloads), un programa que te permitirá sincronizar
los cambios en tu ordenador con los del repositorio en Internet.

Para realizar una colaboración sobre un repositorio debes completar los tres
pasos siguientes:

- Realizar una copia privada del repositorio en tu cuenta y en tu propio
  ordenador
- Programar los cambios y modificaciones sobre ficheros nuevos o ya existentes.
- Sincronizar estos cambios con el repositorio de tu cuenta y solicitar que sean
  también sincronizados con el repositorio original (lo que se llama "pull
  request")

### Crear copia privada del repositorio

El primer paso por tanto es realizar una copia del repositorio en tu
cuenta. Esta copia será de tu propiedad y podrás hacer sobre ella cualquier
cambio que desees. Esto se denomina "Fork" y se puede hacer pulsando sobre el
botón que lleva este nombre en la parte superior derecha de esta misma
pantalla.

Una vez hecho esto solo nos queda descargarnos esta copia en nuestro equipo para
empezar a realizar los cambios que queramos. Para esto tecleamos:

```
git clone https://github.com/tuUsuario/programame
```

### Realizar y subir nuestras modificaciones

Para realizar los cambios es recomendable trabajar en una rama aparte en lugar
de la rama ``master``. En caso de que no conozcamos en profundidad el funcionamiento
de Git podemos evitar este paso, pero si ya has trabajado con ramas te
recomendamos que evites hacer cambios sobre la rama ``master``.

En este punto te recomendamos que trabajes únicamente sobre un problema cada
vez. O bien resuelve un problema que no se ha planteado, ***creando un directorio
nuevo tal y como se indica en la parte superior*** o bien intenta resolver algún
problema que todavía se muestra como No Resuelto (NR).

Cuando ya consideres que tus cambios están listos para ser publicados, primero
debes sincronizarlos con tu propia copia del repositorio. Teclea los siguientes
comandos:

```
git commit -am 'He resuelto el problema XXX'
git push origin master
```

### Sincronizar tu repositorio con el nuestro

Tus cambios ya han sido publicados en tu copia de ``programame`` y todo el mundo
puede ya verlas. Si aún así estas interesado en colaborar en nuestro repositorio
con estas modificaciones solo te queda solicitar que las agreguemos realizando
un "Pull Request".

Situados en la página principal de ***tu*** repositorio de ``programame`` puedes
ver en la zona superior un botón verde donde se lee "New pull request". Púlsalo
y te conducirá a una nueva página donde GitHub compara las ramas que tu quieras
entre nuestro repositorio y el tuyo. Si has realizado los cambios en tu rama
``master`` no necesitar tocar nada y simplemente pulsar el botón verde donde se
lee "Create pull request".

Escribe en el un mensaje descriptivo de como has llegado a la solución del
problema que has resuelto o añade aquí cualquier indicación con la que
justificar la inclusión de este código en nuestro repositorio.

Y esto es todo!

