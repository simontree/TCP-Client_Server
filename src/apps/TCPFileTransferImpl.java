package apps;

import filetransfer.FileReceiver;
import filetransfer.FileSender;
import filetransfer.FileTransferMachine;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPMachine;

import java.io.IOException;

public class TCPFileTransferImpl implements TCPFileTransfer{
    @Override
    public void sendFile2Host(String fileName, String hostName, int portNumber) throws IOException {
        //establish connection
        Client client = new TCPMachine();
        Connection connection = client.connect(hostName, portNumber);

        //send file
        FileSender fileSender = new FileTransferMachine();
        fileSender.sendFile(fileName, connection.getOutputStream());
    }

    @Override
    public void receiveFile(String fileName, int portNumber) throws IOException {
        Server server = new TCPMachine();
        Connection connection = server.acceptConnection(portNumber);

        FileReceiver fileReceiver = new FileTransferMachine();
        fileReceiver.receiveFile(fileName, connection.getInputStream());
    }
}
