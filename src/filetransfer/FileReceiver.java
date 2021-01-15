package filetransfer;

import java.io.IOException;
import java.io.InputStream;

public interface FileReceiver {
    /**
     * receive content from input stream and write to file
     * @param fileName
     * @param is
     * @throws IOException
     */
    void receiveFile(String fileName, InputStream is) throws IOException;
}
