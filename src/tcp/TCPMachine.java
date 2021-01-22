package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMachine implements Client, Server, Connection{
    private Socket socket;

    //ClientImpl
    @Override
    public Connection connect(String hostName, int portNumber) throws IOException {
        this.socket = new Socket(hostName, portNumber);
        return this;
    }

    //ConnectionImpls
    @Override
    public OutputStream getOutputStream() throws IOException {
        return this.socket.getOutputStream();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }

    //ServerImpl
    @Override
    public Connection acceptConnection(int portNumber) throws IOException {
        ServerSocket srvSocket = new ServerSocket(portNumber);
        System.out.println("server socket created");

        //open TCP-Connection -> more accepts = more connections => one connection per accept
        this.socket = srvSocket.accept();
        return this;
    }
}
