package edu.upc.eetac.dsa.davidcanadagordo.EjerciciosEsenciales3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerUDP {
	public static void main(String args[]) throws IOException {
		
		
		DatagramSocket serverSocket = new DatagramSocket(9876); 
		byte[] receiveData = new byte[1024]; 
	    byte[] sendData  = new byte[1024]; 
	    Date date= new Date(); //fecha
	  
	     try 
	        { 
	    	  
	          receiveData = new byte[1024]; //recibes datos
	          DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
	          serverSocket.receive(receivePacket); 
	          
	          
	          SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YYYY  HH: mm: ss");
	          String fecha = formato.format(date);
	          
	          String sentence = new String(receivePacket.getData());   
	          
	          InetAddress IPAddress = receivePacket.getAddress(); 
	  
	          int port = receivePacket.getPort();
	          System.out.println(sentence);
	          System.out.println(fecha);
	          

	          sendData = fecha.getBytes();       //enviamos la fecha    
	          DatagramPacket sendPacket =  new DatagramPacket(sendData, sendData.length, IPAddress, port); 
	          serverSocket.send(sendPacket); 

	         
	        }
	     catch (SocketException e) {
				System.out.println("No puedo crear el socket");
				 System.exit(1);
				 }
	      serverSocket.close();

	     }
	}
	

