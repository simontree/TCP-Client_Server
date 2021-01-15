package client;

import java.io.*;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
        try{
            String name = "localhost";
            int port = 2451;

            //for reading from console
//            String name = args[0];
//            String portString = args[1];
//            int port = Integer.parseInt(portString);

            Socket socket = new Socket(name,port);

            //create outputstream for data to server
            OutputStream os = socket.getOutputStream();

            //send String to Server
            String someText = "Moin moin!";
            byte[] textAsByte = someText.getBytes();
            os.write(textAsByte);

            //create inputstream for data from server
            InputStream is = socket.getInputStream();

            //dataInputStream
            DataInputStream dis = new DataInputStream(is);
            int readIntValue = dis.read();

            //convert inputstream from server into String with StreamReader and BufferedReader
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String readString = br.readLine();
            System.out.println("server input: "+readString);

        }
        catch (IOException ex){
            System.err.println("couldn't connect");
            System.exit(0);
        }
    }
}
