package filetransfer;

import java.io.*;

public class FileTransferMachine implements FileSender, FileReceiver {
    @Override
    public void receiveFile(String fileName, InputStream is) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        this.streamData(is, fos);
    }
    @Override
    public void sendFile(String fileName, OutputStream os) throws IOException {
        //open file
        FileInputStream fis = new FileInputStream(fileName);
        this.streamData(fis, os);
        os.close();
    }
    private void streamData(InputStream is, OutputStream os) throws IOException {
        int read = 0;
        do{
            read = is.read();
            if(read != -1){
                os.write(read);
            }
        }while (read != -1);
    }
}
