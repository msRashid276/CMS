package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import dto.ContactDTO;
import service.ContactService;
import service.ContactServiceImp;

import java.util.stream.*;

public class ContactController implements HttpHandler {
	 private ContactService contactService = new ContactServiceImp();
		

	 @Override
	 public void handle(HttpExchange exchange) throws IOException {
	     String method = exchange.getRequestMethod();
	     String rawPath = exchange.getRequestURI().getPath();
	     String path = rawPath.replaceAll("/+$", "");
	     String response = "";
	     int statusCode = 200;

	     Gson gson = new Gson();
	     
	     System.out.println("HTTP " + method + " " + path);

	     try {
	         if ("GET".equalsIgnoreCase(method)) {
	             if (path.matches("/contacts/\\d+")) {
	                 int id = Integer.parseInt(path.substring("/contacts/".length()));
	                 System.out.println("Getting contact by ID: " + id);
	                 ContactDTO contact = contactService.getContactById(id);
	                 if (contact != null) {
	                     response = gson.toJson(contact);
	                 } else {
	                     statusCode = 404;
	                     response = gson.toJson("Contact not found");
	                 }
	             } else if (path.equals("/contacts")) {
	                 System.out.println("Getting all contacts");
	                 List<ContactDTO> contacts = contactService.getAllContacts();
	                 response = gson.toJson(contacts);
	             } else {
	                 statusCode = 404;
	                 response = gson.toJson("Endpoint not found");
	             }
	         } else if ("POST".equalsIgnoreCase(method)) {
	             System.out.println("Adding new contact");
	             String body = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))
	                               .lines()
	                               .collect(Collectors.joining("\n"));
	             System.out.println("Request body: " + body);	             
	             ContactDTO newContact = gson.fromJson(body, ContactDTO.class);
	             if (newContact == null) {
	                 statusCode = 400;
	                 response = gson.toJson("Invalid contact data");
	             } else {
	                 contactService.addContact(newContact);
	                 response = gson.toJson("Contact added successfully");
	                 statusCode = 201;
	             }
	         } else if ("PUT".equalsIgnoreCase(method) && path.matches("/contacts/\\d+")) {
	             int id = Integer.parseInt(path.substring("/contacts/".length()));
	             System.out.println("Updating contact with ID: " + id);
	             String body = new BufferedReader(new InputStreamReader(exchange.getRequestBody()))
	                               .lines()
	                               .collect(Collectors.joining("\n"));
	             ContactDTO updatedContact = gson.fromJson(body, ContactDTO.class);
	             if (updatedContact == null) {
	                 statusCode = 400;
	                 response = gson.toJson("Invalid contact data");
	             } else {
	                 contactService.updateContact(id, updatedContact);
	                 response = gson.toJson("Contact updated successfully");
	             }
	         } else if ("DELETE".equalsIgnoreCase(method) && path.matches("/contacts/\\d+")) {
	             int id = Integer.parseInt(path.substring("/contacts/".length()));
	             System.out.println("Deleting contact with ID: " + id);
	             contactService.deleteContact(id);
	             response = gson.toJson("Contact deleted successfully");
	         } else {
	             statusCode = 405;
	             response = gson.toJson("Method Not Allowed");
	         }
	     } catch (Exception e) {
	         e.printStackTrace();
	         statusCode = 500;
	         response = gson.toJson("Internal Server Error: " + e.getMessage());
	     }

	     exchange.getResponseHeaders().set("Content-Type", "application/json");
	     exchange.sendResponseHeaders(statusCode, response.getBytes().length);
	     OutputStream os = exchange.getResponseBody();
	     os.write(response.getBytes());
	     os.close();
	 }
}
       
       
       
    	   
	


       
		
	


