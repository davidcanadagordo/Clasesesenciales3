package edu.upc.eetac.dsa.davidcanadagordo.EjerciciosEsenciales3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Server14 {


	private static ServerSocket Servidor;
	private static int puerto = 5000;
	private static DataOutputStream salida;
	private static DataInputStream entrada;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static String date = sdf.format(new Date());
	
	public static void main(String[] args) {
		

		try {

			Servidor = new ServerSocket(puerto);
			Socket conexion;
			
			while (true) {
				conexion = Servidor.accept();
				Threads nuevaConexion = new Threads(conexion);
				nuevaConexion.start();
			}

		} catch (Exception e) {}
		
}
	
public class Threads extends Thread {
		
		private Socket cliente;
		private DataOutputStream salida;
		private DataInputStream entrada;
		private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		private SimpleDateFormat sdf2 = new SimpleDateFormat("E,d MMM, HH:mm:ss");
		private String date; 
		public Threads(Socket cliente){
			this.cliente=cliente;
		}
		
		public void run(){
			try{
			
				salida = new DataOutputStream(cliente.getOutputStream());
				salida.flush();

				entrada = new DataInputStream(cliente.getInputStream());
				
				
				int opcion = Integer.valueOf(entrada.readUTF());
				
				
				
				switch(opcion){
				
				case 0 : 	date= sdf.format(new Date());
							salida.writeUTF(date);
							break;
				case 1 :	
							date = sdf2.format(new Date());
							salida.writeUTF(date);	
							break;
				}
			
				
			}catch(Exception e){}
		}
	}
}
	
