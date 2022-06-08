# TallerSolid


## El sistema ejecuta una pequeña secuencia de pasos para probar el funcionamiento del código fuente:
 1.	Producir un helado de vainilla y una torta de chocolate
 2.	A ambos agregarles CREMA y FRUTILLAS como aderezos 
 3.	A ambos cambiar el tipo de leche por Leche Deslactosada
 4.	Finalmente mostrar el precio final de cada postre.



## Analice las siguientes partes del código, explique su análisis en el archivo README.md y corrija el código para que cumpla con los principios SOLID.
 1.	Clases Helado y Pastel. Tienen mucha similitud, se debería crear una clase padre llamada Postre.
 
 	 Análisis: Se vulnera el principio 2 Open/Closed Principle dado que hay clases que realizan tareas similares, el principio nos habla que debemos poder extender comportamientos de una clase sin modificarla, en este caso tenemos un produco más general que es Postre que recopile las caacterísicas que comparten Helado y Pastel.
  
2.	Clases Procesos.OperacionesAderezo y Postre. ¿Es necesaria la clase OperacionesAderezo?. Se puede incluir dentro de postre un método para agregar un aderezo y para quitar un aderezo.



 3.	Métodos calcularPrecioFinal() y  showPrecioFinal() están muy relacionados, deben estar en otra clase por si cambia la fórmula de cálculo. La clase nueva debe llamarse Procesos.ManejadorDePrecio.


 4.	Enum Adicionales.Aderezo es muy estático, debe convertirse en clase abstract con un atributo nombre y un método abstracto setNombre para que cada tipo de aderezo sea una subclase de Aderezo e implemente dicho método. También, sobrescriba el método toString() en la clase Aderezo, para que devuelva el nombre del aderezo en mayúsculas.


 5.	Paquete Leche y la clase Procesos.ManejadorDeLeche. En el main descomente las instrucciones para realizar el cambio del tipo de leche utilizada en cada postre, luego analice como solucionar el error generado en la clase Leche.LecheDeslactosada.
 
 6.	Cambie el main por el siguiente código y ajuste según su propia implementación.
 
