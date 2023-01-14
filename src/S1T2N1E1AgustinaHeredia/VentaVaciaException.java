package S1T2N1E1AgustinaHeredia;


public class VentaVaciaException extends Exception{
	 
	
	public static final char[] getMensaje = null;
	
	public VentaVaciaException() {
        		super(getMensaje());
    }
	public static final String getMensaje(){
		return "Para hacer una venta primero debes añadir productos.";
	}
}
