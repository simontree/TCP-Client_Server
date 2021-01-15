package filetransfer;

import java.io.IOException;
import java.io.OutputStream;

public interface FileSender {

    /**
     * send file from local via outputstream
     * @param fileName
     * @param os
     * @throws IOException
     */
    void sendFile(String fileName, OutputStream os) throws IOException;
}
