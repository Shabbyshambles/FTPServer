package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class myFTPclient {

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Connect to what ip?");
        String host = keyboard.nextLine();

        System.out.println("Connect to which port?");
        int port = keyboard.nextInt();

        try(Socket socket = new Socket(host, port)){

            InputStream input = socket.getInputStream();
            BufferedReader buff = new BufferedReader(new InputStreamReader(input));

            String time = buff.readLine();

            System.out.println(time);

        }
        catch(UnknownHostException ex){
            System.out.println("Server not found: " + ex.getMessage());
        }catch(IOException ex){
            System.out.println("I/O error: " + ex.getMessage());
        }


    }
    
}
