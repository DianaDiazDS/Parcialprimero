# evaluacion-individual-Electiva2
## Acceso

http://localhost:8080/
##orden

Primero se crea cliente
segundo se crea producto
tercero se crea la venta con el id por param del cliente y en el body el id del producto
junto con la cantidad que desea de ese producto, si se exede del valor del producto
no se crea la venta


## Rutas
Para GET sales:
- /sales Retorna todos los elementos guardados en sales
- /sales/{id} Retorna el elemento con un id especifico

Para GET product:
- /sales Retorna todos los elementos guardados en sales
- /sales/{id} Retorna el elemento con un id especifico

Para GET customers:
- /customers Retorna todos los elementos guardados en customers
- /customers/{id} Retorna el elemento con un id especifico

Para POST, PUT y DELETE respectivamente
- /sale/{id} Envia y guarda los datos ingresados
- /sales/{id} Actualiza el id con los datos ingresados
- /sales/{id} Elimina los datos con el id ingresado


Para POST, PUT y DELETE respectivamente
- /customers/{id} Envia y guarda los datos ingresados
- /customers/{id} Actualiza el id con los datos ingresados
- /customers/{id} Elimina los datos con el id ingresado
  Para POST, PUT y DELETE respectivamente
- /customers/{id} Envia y guarda los datos ingresados
- /customers/{id} Actualiza el id con los datos ingresados
- /customers/{id} Elimina los datos con el id ingresado