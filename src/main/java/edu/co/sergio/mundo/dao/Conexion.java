package edu.co.sergio.mundo.dao;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Conexion {
	
	private static Connection CONEXION=null;
    	public static Connection getConnection() throws URISyntaxException{
        String HOST = "ec2-107-20-224-137.compute-1.amazonaws.com"; 
        String DATABASE = "d2arfsi0ag1o88";
        String USER = "bpoxiukukayjcc";
        String PASS = "0e3df65f254449697112e793ea49d1479eb617030e68565596c365437629fdaa";

//      URI dbUri = new URI(System.getenv("DATABASE_URL"));
//      String username = dbUri.getUserInfo().split(":")[0];
//      String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" +
                HOST + "/" + DATABASE +
                "?user=" + USER  + "&password=" + 
                PASS + "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    
		   if(CONEXION == null){
			  	try {
					CONEXION = DriverManager.getConnection(dbUrl);
                        	} catch (SQLException e) {
					System.out.println("Connection Failed! Check output console");
					e.printStackTrace();
				}

				
		   }
		   return CONEXION;
	}
	
	public static void closeConnection(){
		 try {
			 if(CONEXION!=null){
				 CONEXION.close();
				 CONEXION=null;
			 }
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}
	

}
