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
