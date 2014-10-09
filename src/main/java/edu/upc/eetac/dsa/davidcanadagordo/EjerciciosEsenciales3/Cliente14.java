package edu.upc.eetac.dsa.davidcanadagordo.EjerciciosEsenciales3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente14 {
	public static void main(String[] args) {
		try {
			
			Socket s = new Socket("127.0.0.1", 1234);
			PrintStream writer = new PrintStream(s.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			int mensaje;
            Scanner sc = new Scanner();
			System.out.print("Introduce un 0 o un 1:");
			mensaje = Integer.parseInt(sc.next());
			writer.println(mensaje);
			
			String serverrequest = reader.readLine();
			
			System.out.print(serverrequest);
			s.close();
			
			
		} catch (UnknownHostException ex) {
			Logger.getLogger(Cliente14.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IOException ex) {
			Logger.getLogger(Cliente14.class.getName()).log(Level.SEVERE, null,
					ex);
		}

	}
}

