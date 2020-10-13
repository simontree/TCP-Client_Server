package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
        try{
            String name = "localhost";
            int port = 3333;
            Socket socket = new Socket(name,port);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
        }
        catch (IOException ex){
            System.err.println("couldn't connect");
            System.exit(0);
        }
    }
}
