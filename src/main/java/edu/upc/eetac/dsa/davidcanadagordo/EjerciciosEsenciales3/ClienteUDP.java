package edu.upc.eetac.dsa.davidcanadagordo.EjerciciosEsenciales3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteUDP {

	public static void main(String[] args) throws IOException{
		
	String serverHostname = new String ("127.0.0.1");
	 
	try { 
		 
	 
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			DatagramSocket clientSocket = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName(serverHostname);
			 
			
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			
			String hora = "¿Qué hora es?";
			System.out.print(hora);
			sendData = hora.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, 9876);
		    clientSocket.send(sendPacket);
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
			
	try {
		
			clientSocket.receive(receivePacket);
			String modifiedSentence = new String(receivePacket.getData());
			System.out.println(modifiedSentence);
		
			InetAddress returnIPAddress = receivePacket.getAddress();
			System.out.println("ipserver" +returnIPAddress);
		
			int port = receivePacket.getPort();
			System.out.println("puerto" + port);
	
	}
	
	catch (SocketException e) {
		System.out.println("No puedo crear el socket");
		 System.exit(1);
		 }
	
	clientSocket.close();
	}
	
	catch (UnknownHostException e) { 
	     System.err.println(e);
	    }
	
	
	}

}
