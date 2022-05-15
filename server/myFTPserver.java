package server;

import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.*;
import java.util.Date;

public class myFTPserver{

public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Which port would you like to open on?");
    int Port = keyboard.nextInt();
    try(ServerSocket mySocket = new ServerSocket(Port)){

        System.out.println("Listening on port: " + Port);

        while(true){
            Socket socket = mySocket.accept();
            System.out.println("New connection established");

            OutputStream output = socket.getOutputStream();

            PrintWriter writer = new PrintWriter(output,true);

            writer.println(new Date().toString());
        }


    }
    catch(IOException ex){
        System.out.println("Server exception: " + ex.getMessage());
        ex.printStackTrace();
    }

}



}
