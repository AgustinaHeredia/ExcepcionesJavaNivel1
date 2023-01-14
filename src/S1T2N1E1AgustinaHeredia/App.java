package S1T2N1E1AgustinaHeredia;
import java.util.Scanner;
import java.util.ArrayList;
public class App {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Producto> listaProductos = new ArrayList<Producto>();

	public static void main(String[] args) {
		Venta ventas = new Venta();
		
		int seleccion=0;
		do {
			menuApp();
			seleccion = pedirInt("¿Qué deseas realizar?");
			
			switch (seleccion){
			case 0:
				System.out.println("Has elegido salir de la aplicación. Hasta pronto.");
			break;
			case 1:

				crearProducto(pedirString("Escribe el nombre del producto"),pedirDouble("Indica el precio"));
				break;
			case 2:
				mostrarProducto(pedirString("Escribe el nombre del producto que deseas ver."));
				break;
			case 3:
				mostrarListaProductos();
				break;
			case 4:
				eliminarProducto(pedirString("Escribe el nombre del producto que deseas eliminar."));
				break;
			case 5:
				try {
				System.out.println("El precion total de las ventas es :"+ ventas.calculaTotal());
				}catch (VentaVaciaException e) {
					System.err.println(e.getMessage());
				}
				break;
			}
		}while (seleccion !=0);

	}
	
	public static Producto crearProducto(String nombre, double precio) {
		Producto producto = new Producto(nombre, precio);
		listaProductos.add(producto);
		return producto;
	}
	public static void mostrarProducto(String nombre) throws IndexOutOfBoundsException {
		try {
		String productoVer= nombre;
		int posicionProducto=buscarIndiceProducto(listaProductos,productoVer);
		
		Producto producto=listaProductos.get(posicionProducto);
		System.out.println(producto.toString());
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("El producto no se ha encontrado en la base de datos, o la lista está vacia." );
		}

		
	}
	public static void mostrarListaProductos() {
		System.out.println("Los productos de la lista son:");
		for (int i=0;i<listaProductos.size();i++) {
		      
		      System.out.println("- "+listaProductos.get(i).toString());
		    }
	}
	public static void eliminarProducto(String nombre) throws IndexOutOfBoundsException {
		try {
		String productoEliminar=nombre;
		buscarIndiceProducto(listaProductos,productoEliminar);
		int posicion=buscarIndiceProducto(listaProductos,productoEliminar);
		
		
		Producto producto=listaProductos.get(posicion);
		listaProductos.remove(producto);
		System.out.println("El producto se ha eliminado de la base de Datos correctamente");
		
		}catch (IndexOutOfBoundsException e) {
			System.out.println("El producto no se ha encontrado en la base de datos, o la lista está vacia." );
		}
			
	}
	
	//Herramientas
		public static int buscarIndiceProducto(ArrayList<Producto> listaProductos,String nom) {
		    int posicion = -1;
		    int i = 0;
		    boolean encontrado = false;
		    while(i<listaProductos.size()&& encontrado==false) {
		          if (listaProductos.get(i).getNombre().equalsIgnoreCase(nom)) {
		              posicion = i;
		              encontrado = true;
		          }
		          i++;
		    }
		    return  posicion;
		}
		
	
	static void menuApp() {
		System.out.println("ELIGE LA OPCIÓN QUE QUIERES REALIZAR");
		System.out.println("0.- Salir de la aplicación.");
		System.out.println("1.- Crear producto.");
		System.out.println("2.- Ver producto");
		System.out.println("3.- Mostrar lista.");
		System.out.println("4.- Eliminar producto");
		System.out.println("5.- Calcular precio total productos");
		
	}
	static String pedirString(String texto) {
		System.out.println(texto);
		String nom = input.next();
		return nom;
	}

	static int pedirInt(String texto) {
		System.out.println(texto);
		int n1 = input.nextInt();
		return n1;
	}
	static double pedirDouble(String texto) {
		System.out.println(texto);
		double d1 = input.nextDouble();
		return d1;
	}
}
