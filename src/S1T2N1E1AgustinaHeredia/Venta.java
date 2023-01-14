package S1T2N1E1AgustinaHeredia;
import java.util.ArrayList;
public class Venta {
	private ArrayList <Producto> listaProductos;
	private double precioTotalVenta;

	public Venta () {
		this.listaProductos = new ArrayList<Producto>();
		this.precioTotalVenta = 0;
	}
	
	public ArrayList<Producto> getListaProductos (){
		return listaProductos;
	}
	public double getPrecioTotalProductos() {
		return precioTotalVenta;
	}
	
	
	public double calculaTotal() throws VentaVaciaException{
		if (listaProductos.isEmpty()) {
			throw new VentaVaciaException("Para hacer el calculo de venta primero debes añadir productos.");
		}
		else {
			double n=0;
		
			for (int i = 0; i < listaProductos.size(); i++) {
		
				n=n+(listaProductos.get(i).getPrecio());
		
			}
			precioTotalVenta= n/listaProductos.size();
		
		
			return precioTotalVenta;
		}	
		
	}
		
		
		
}
