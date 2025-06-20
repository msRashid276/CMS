import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;


import com.sun.net.httpserver.HttpServer;

import Controller.ContactController;

public class Main {
	

public static void main(String[] args) throws Exception{
	
	HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
	server.createContext("/contacts",new ContactController());
	server.setExecutor(null);
	server.start();
	System.out.println("Server started onport 8080");
	}
	




	



	

}
