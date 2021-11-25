
public class Ciudad extends Thread{
	//Características
	String nombre="CIUDAD";
	int poblaciónInicial=100;
	int poblacionActual=poblaciónInicial;
	AlmacenComida aComida;

	public Ciudad(String nombre, AlmacenComida aComida) {
		this.nombre=nombre;
		this.aComida=aComida;
	}

	public void run() {
		try {
			while(poblacionActual>0) {
				//De forma aleatoria nacen y mueren habitantes. Además lo hacen de una forma en tiempo también aleatoria
				sleep((int) Math.floor(Math.random()*100)); //Esperamos un tiempo aleatorio
				int nacimientos=(int) Math.floor(Math.random()*5); //Nacen un numero aleatorio entre 0 y 5
				System.out.println("["+this.nombre+"] Ha tenido "+nacimientos+" nacimientos");
				poblacionActual=poblacionActual+nacimientos;
				//Se solicita la comida para la población actual
				boolean hayComida=this.aComida.solicitarComida(poblacionActual,this.nombre);
				if (!hayComida) {
					sleep((int) Math.floor(Math.random()*100));//Esperamos un tiempo aleatorio
					int muertes=(int) Math.floor(Math.random()*10); //Mueren un numero aleatorio entre 0 y 10
					System.out.println("["+this.nombre+"] Ha tenido "+muertes+" muertes");
					poblacionActual=poblacionActual-muertes;//Restamos las muertes
				}
			}
			System.out.println("["+this.nombre+"] HA DESAPARECIDO");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
