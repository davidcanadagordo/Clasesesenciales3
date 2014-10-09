package edu.upc.eetac.dsa.davidcanadagordo.EjerciciosEsenciales3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerTCPConcur {
	public static void main(String[] args) throws IOException {

		ServerSocket s = null; //Socket servidor
		Socket sc = null; //Socket cliente

		PrintWriter out = null; //Canal de escritura
		InputStreamReader in = null; //Canal de Lectura
		BufferedReader br = null;
		String fecha;
	
		while(true)
		{
			
		try {
	
		s = new ServerSocket(52978);
        sc = s.accept();
		out = new PrintWriter(sc.getOutputStream());
	    in = new InputStreamReader(sc.getInputStream());
	    br = new BufferedReader(in);
		
		    }
		catch (IOException e) {
			System.out.println("No puedo crear el socket");
			 }
		
		  Thread t = new Thread();
		 
		
			public void run() 
			{
				String mensaje;
				Date date = new Date();
				
				SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				System.out.println(formateador.format(new Date()));
				fecha = formateador.format(date);
				}
			t.start();

		   }
		
		 
		
		
		
		

		
		String inputLine;
		 
		while ((inputLine = br.readLine()) != null) 
	        { 
	    	 out.write("Fecha: " + fecha);
	         out.println(inputLine); 

	        } 
	
	
	    sc.close();
		s.close();
		out.close();
		
	}
	 
	public void run() {
	        System.out.println("Hello from a thread!");
	    }

	
		
	}

	
		
		
	
	
	