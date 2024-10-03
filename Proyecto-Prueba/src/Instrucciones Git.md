## Comandos de Git
 1. `git status`: Verifica los archivos y en qué estado están
 2. `git add Archivo.archivo`: Agrega el archivo a la fase stage y lo prepara para el commit, se debe escribir en las comillas el nombre  exacto del archivo. NOTA: si git add *, se puede preparar todos los cambios de los archivos pero OJO, se pueden cometer errores
 3. `git commit -m "mensaje"`: Hace commit de los archivos, el mensaje debe ser significativo.
 4. `git push -u origin main`: Sube los archivos al repositorio en la rama main.

## Comandos de ramas o branch.
 1. `git branch`: Visualiza en que rama estás localmente.
 2. `git checkout -b "nombreRama"`: Crea una nueva rama local.
 3. `git push -u origin "nombreRama"`: Sube los archivos al repositorio y agrega su rama local a éste, se debe repetir éste comando a menos que se quiera subir al main.

## Comandos normales
 -  `clear`: Limpia la consola
 -  Extension recomendada: Git graph, visualiza el flujo de trabajo.

## Importante
 -  Verificar en que rama se encuentran antes de hacer cambios y especialmente antes de hacer push.