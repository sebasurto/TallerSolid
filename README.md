
# TallerSolid

##### Stephany Cabezas
##### Victor García
##### Sergio Basurto

## El sistema ejecuta una pequeña secuencia de pasos para probar el funcionamiento del código fuente:
 1.	Producir un helado de vainilla y una torta de chocolate
 2.	A ambos agregarles CREMA y FRUTILLAS como aderezos 
 3.	A ambos cambiar el tipo de leche por Leche Deslactosada
 4.	Finalmente mostrar el precio final de cada postre.

![image](https://user-images.githubusercontent.com/35089326/172727233-262ec06e-f3a0-448f-8b16-9bf38336f1fc.png)


## Analice las siguientes partes del código, explique su análisis en el archivo README.md y corrija el código para que cumpla con los principios SOLID.
 1.	Clases Helado y Pastel. Tienen mucha similitud, se debería crear una clase padre llamada Postre.
 
  ##### Análisis: Se vulnera el principio 2 Open/Closed Principle dado que hay clases que realizan tareas similares, el principio nos habla que debemos poder extender comportamientos de una clase sin modificarla, en este caso tenemos un produco más general que es Postre que recopile las caacterísicas que comparten Helado y Pastel. 
  ```
  public class Pastel extends Postres{} //
  public class Helado extends Postres{} //
  
  public abstract class Postres{
  private String sabor;
  private double precioParcial;
  private ArrayList<Aderezo> aderezos;
  
  public abstract double calcularPrecioFinal();
  public abstract ArrayList<Aderezo> getAderezos();
  public abstract String toString();
  public abstract String showPrecioFinal();
  }
  ```
  
2.	Clases Procesos.OperacionesAderezo y Postre. ¿Es necesaria la clase OperacionesAderezo?. Se puede incluir dentro de postre un método para agregar un aderezo y para quitar un aderezo.

   ##### Análisis: Podria mantenerse y cumplir con el cuarto principio de Interface Segregation Principle, para no usar muchos métodos en una interfaz que no usaremos mucho, dado que no siempre usaremos el añadir o quitar un aderezo, pero adecuamos el método para que tome la nueva clase padre Postre.

```
public class OperacionesAderezo {
    public static void anadirAderezoPostres(Postres helado,Aderezo aderezo){
        helado.getAderezos().add(aderezo);
    }
    public static void quitarAderezoPostres(Postres helado,Aderezo aderezo){
        helado.getAderezos().remove(aderezo);
    }
}
```

 3.	Métodos calcularPrecioFinal() y  showPrecioFinal() están muy relacionados, deben estar en otra clase por si cambia la fórmula de cálculo. La clase nueva debe llamarse Procesos.ManejadorDePrecio.

  ##### Análisis: 
```
package Procesos;

import Postres.Postres;

public class ManejadorDePrecio {
	
	Postres postre;
	
	public String showPrecioFinal(){
        return "Precio Final: $ " + calcularPrecioFinal();
    }
	
	public double calcularPrecioFinal(){
        double precioFinal;
        precioFinal=(precioParcial+(precioParcial*0.12))+(aderezos.size()*0.50);
        return precioFinal;
    }
}
```
 4.	Enum Adicionales.Aderezo es muy estático, debe convertirse en clase abstract con un atributo nombre y un método abstracto setNombre para que cada tipo de aderezo sea una subclase de Aderezo e implemente dicho método. También, sobrescriba el método toString() en la clase Aderezo, para que devuelva el nombre del aderezo en mayúsculas.

  ##### Análisis: Cómo debemos implementar subclases usando el padre, debemos usar el principio de sustitución de Liskov, dado que debemos usarlas sin generar fallos o alterar su funcionamiento, utilizando al padre.
  
```
package Adicionales;

public abstract class Aderezo {
public String name;
public Aderezo(String name) {
		this.name=name;
}
public String toString() {
        return this.name.toUpperCase();
}
	 
public abstract void  setNombre (String name);	 
}
```

 5.	Paquete Leche y la clase Procesos.ManejadorDeLeche. En el main descomente las instrucciones para realizar el cambio del tipo de leche utilizada en cada postre, luego analice como solucionar el error generado en la clase Leche.LecheDeslactosada.

   ##### Análisis: Principio de inversión de dependencias, "En algún momento nuestro programa o aplicación llegará a estar formado por muchos módulos. Cuando esto pase, es cuando debemos usar inyección de dependencias, lo que nos permitirá controlar las funcionalidades desde un sitio concreto en vez de tenerlas esparcidas por todo el programa." tomado de (https://enmilocalfunciona.io/principios-solid/). El programa depende de un módulo de bajo nivel, que por diseño podriamos manejar de otro módulo, para que no mande el error podemos obviar la exepción para dar partida a que el código pueda crecer en una futura implemntación. 
```
public class LecheDeslactosada extends LecheEntera {
    
    @Override
    public void usarHelado() {
        System.out.println("Usando leche deslactosada");
    }

    @Override
    public void usarPastel() {
        // Lanzar error No se puede usar en pastel
    	System.out.println("No se puede usar leche deslactosada en el pastel");
    	//throw new RuntimeException(this.getClass() + ": No se puede usar en pastel");
    }
        
}
```
6.	Cambie el main por el siguiente código y ajuste según su propia implementación.
 
 
 
        public static void main(String [ ] args){
        // Producir un helado de vainilla y una torta de chocolate, 
        // a ambos agregarles CREMA y FRUTILLAS
        // y cambiar el tipo de leche por Leche Deslactosada
        ArrayList<Postre> arrPostres = new ArrayList<>();
        ManejadorDeLeche mnj_leche = new ManejadorDeLeche(new LecheDescremada());
        // Producir Helado
        Postre helado_vainilla = new Helado("Vainilla");
        arrPostres.add(helado_vainilla);
        // Producir Pastel
        Postre pastel_chocolate = new Pastel("Chocolate");
        arrPostres.add(pastel_chocolate);
        
        arrPostres.forEach(postre -> {
            postre.addAderezos(new Crema());
            postre.addAderezos(new Frutilla());
            System.out.println(postre);
            mnj_leche.cambiarTipoLeche(postre);
            System.out.println(ManejadorDePrecio.showPrecioFinal(postre));
        });
        }        
     
        
    


 
 #####   Análisis: 
