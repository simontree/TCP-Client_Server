package server;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public void TCPServer(){

    try{
        int port = 2451;
        //assign port 2451 to serversocket
        ServerSocket server = new ServerSocket(port);

        //receive connection requests from client
        Socket clientRequest = server.accept();
        System.out.println("Clientrequest: " +clientRequest);

        //create inputstream for data from client
        InputStream is = clientRequest.getInputStream();
        System.out.println("inputStream: " +is);

        //dataInputStream
        DataInputStream dis = new DataInputStream(is);
        int readIntValue = dis.read();
        System.out.println("read input int: "+ readIntValue);

        OutputStream os = clientRequest.getOutputStream();

        //send String to Client
        String someText = "Moin";
        byte[] textAsByte = someText.getBytes();
        os.write(textAsByte);

        //pause
        Thread.sleep(5000);

        //close outputstream
        os.close();
    }
    catch(IOException | InterruptedException ex){
        System.err.println("couldn't write data (fatal)");
        System.exit(0);
    }
    }
}
