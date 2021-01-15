package server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args){

    try{
        int port = 2451;
        //assign port 2451 to serversocket
        ServerSocket server = new ServerSocket(port);

        //receive connection requests from client
        Socket socket = server.accept();
        System.out.println("Clientrequest: " +socket);

        //create inputstream for data from client
        InputStream is = socket.getInputStream();
        System.out.println("inputStream: " +is);

        //dataInputStream
        DataInputStream dis = new DataInputStream(is);
        int readIntValue = dis.read();
        System.out.println("read input int: "+ readIntValue);

        //convert inputstream into String with StreamReader and BufferedReader
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String readString = br.readLine();
        System.out.println("client input: "+readString);

        //create outputstream
        OutputStream os = socket.getOutputStream();

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
