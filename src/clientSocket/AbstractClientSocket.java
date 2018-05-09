package clientSocket;

import java.io.BufferedInputStream;
import java.io.IOException;

public abstract class AbstractClientSocket {
     public String read(BufferedInputStream reader) throws IOException {

        String response = "";

        int stream;

        byte[] b = new byte[4096];

        stream = reader.read(b);

        response = new String(b, 0, stream);

        return response;

    }
}
