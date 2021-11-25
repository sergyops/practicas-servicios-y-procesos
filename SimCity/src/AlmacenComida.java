
public class AlmacenComida implements Runnable{
	
	int totalComida=500;

	public AlmacenComida() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1000); //Esperamos 1 segundo para generar 10 unidades de comida
			totalComida=totalComida+10;
			System.out.println("[ALMACEN] Se han producido "+10+" uds de comida");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Procedimiento que devuelve cuanta comida hay en el Almacén
	public int comidaDisponible(){
		return this.totalComida;
	}
	public synchronized boolean solicitarComida(int cantidadComida ,String ciudad) {
		try {
			if(cantidadComida<=this.totalComida) {
				Thread.sleep(cantidadComida * 10);//simulamos la preparación de la comida multiplicando la cantidad solicitada por 10 milisegundos
				totalComida = totalComida - cantidadComida;//restamos del total de comida la comida solicitada
				System.out.println("[ALMACEN] La ciudad "+ciudad+" ha recibido "+cantidadComida+" uds de comida");
				return true;
			}else {
				System.out.println("[ALMACEN] no hay suficiente comida para abastecer a la ciudad "+ciudad);
				return false;
			}
		}catch (InterruptedException e) {
			return false;
		}
	}
}
