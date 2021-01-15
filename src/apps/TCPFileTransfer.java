package apps;

import java.io.IOException;

public interface TCPFileTransfer {

    /**
     * send file from local to remote
     * @param fileName of file to transfer
     * @param hostName  of destination
     * @param portNumber of destination port
     * @throws IOException
     */
    void sendFile2Host(String fileName, String hostName, int portNumber) throws IOException;

    /**
     * receive file from certain portnumber
     * @param fileName
     * @param portNumber
     * @throws IOException
     */
    void receiveFile(String fileName, int portNumber) throws IOException;
}
