package tcp;

import java.io.IOException;

public interface Client {
    Connection connect(String hostName, int portNumber) throws IOException;
}
