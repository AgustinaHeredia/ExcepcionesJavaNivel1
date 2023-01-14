package S1T2N1E1AgustinaHeredia;

public class Producto {
	private String nombre;
	 private double precio;
	
	public Producto(String nombre, double precio) {
		this.nombre=nombre;
		this.precio=precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double nuevoPrecio) {
		precio= nuevoPrecio;
	}
	@Override
	public String toString() {
	return "Nombre del producto es: " + nombre + ", y su precio: " + precio + "€";
	}
}
