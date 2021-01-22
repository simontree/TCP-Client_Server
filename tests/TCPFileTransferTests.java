
import filetransfer.FileReceiver;
import filetransfer.FileSender;
import filetransfer.FileTransferMachine;
import org.junit.Test;
import tcp.Client;
import tcp.Connection;
import tcp.Server;
import tcp.TCPMachine;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TCPFileTransferTests {

    static String HOST = "localhost";
    static int PORT = 100;

    // lesson learned:
    // not testable in one unit test, as server and client have to be two separate entities

    @Test
    public void goodTCPFileTransferTest1() throws IOException {

        Server server = new TCPMachine();
        Connection serverConnection = server.acceptConnection(PORT);

        Client client = new TCPMachine();
        Connection clientConnection = client.connect(HOST, PORT);

        //create file
        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("file.txt"));
        dataOut.writeUTF("hello");

        //send file
        FileSender fileSender = new FileTransferMachine();
        fileSender.sendFile("file.txt", clientConnection.getOutputStream());

        //receive file
        FileReceiver fileReceiver = new FileTransferMachine();
        fileReceiver.receiveFile("file.txt", serverConnection.getInputStream());

    }
}
