package utility;

import apps.TCPFileTransfer;
import apps.TCPFileTransferImpl;

import java.io.IOException;

/**
 * UI for file transfer:
 * expected parameters:
 * 1) send: fileName, receiver's hostname, portNumber
 * 2) receive: fileName, portNumber
 */

public class TCPFileTransferUI {
    public static void main(String[] args) throws IOException {
    if(args.length < 2){
        System.err.println("at least two arguments required");
        return;
    }
    String fileName = args[0];
    String hostName = null;
    int portNumber = -1;

    String portString = null;

        //case 1 for sending -> client
    if(args.length == 3) {
        hostName = args[1];
        portString = args[2];
    }else{
        //case 2 for receiving -> server
        if(args.length == 2) {
            portString = args[1];
        }
    }

    TCPFileTransfer tcpFileTransfer = new TCPFileTransferImpl();
    portNumber = Integer.parseInt(portString);

    if(hostName == null){
        //receive
        tcpFileTransfer.receiveFile(fileName,portNumber);
    }else{
        //send
        tcpFileTransfer.sendFile2Host(fileName,hostName,portNumber);
    }
}
}
