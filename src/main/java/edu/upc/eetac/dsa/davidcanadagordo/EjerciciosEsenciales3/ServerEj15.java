package edu.upc.eetac.dsa.davidcanadagordo.EjerciciosEsenciales3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;

public class ServerEj15 {
	static int cont = 0;

	public static void main(String args[]) {

		// Establecemos el n�mero de puerto a utilizar.
		int serverPort = 8000;
		ServerSocket listenSocket;
        Socket clientSocket; //socket
        Collection c;

		try {

			// Creamos el objeto para esperar peticiones de los clientes.
			listenSocket = new ServerSocket(serverPort);

			while (true) {

				//esperamos clientes
				System.out.println("Esperando nueva conexi�n");
				clientSocket = listenSocket.accept();
				//Conectamos con el cliente
				c = new Collection(clientSocket);
				cont++;

			}

			// Control de excepciones.
		} catch (IOException e) {
			System.out.println("Error en socket: " + e.getMessage());
		}
	}
}}