package edu.upc.eetac.dsa.davidcanadagordo.EjerciciosEsenciales3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCPConcur {
	
		public static void main(String[] args) throws IOException{

			Socket sc = null;
	        PrintWriter out = null;
	        BufferedReader in = null;

			String host = "localhost";
			int port = 52978;
			

			
			try {

			//Creo una conexion al socket servidor
			sc = new Socket(host,port);

			//Creo las referencias al canal de escritura y lectura del socket
			out = new PrintWriter(sc.getOutputStream());
			in = new BufferedReader (new InputStreamReader(sc.getInputStream()));
			
			}
			
		    catch (IOException e) {
				System.out.println("Error de E/S en " + host + ":" + port);
				}
			
			 System.out.print ("¿Qué hora es?");
			
			 String fecha;
			 
				while ((fecha = in.readLine()) != null) 
			        { 
			    	 out.write("Fecha: " + fecha);
			         out.println(fecha); 

			        } 
			/* while ( true ) 
			{
			
			//Espero la respuesta por el canal de lectura
			respuesta = b.readLine();
			System.out.println(respuesta);
		
			}
			
			*/
			
				sc.close();
			    in.close();
				out.close();
		    
			}
			}
		

