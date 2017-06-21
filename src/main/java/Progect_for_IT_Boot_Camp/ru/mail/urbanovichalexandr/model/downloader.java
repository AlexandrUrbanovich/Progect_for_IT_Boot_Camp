package Progect_for_IT_Boot_Camp.ru.mail.urbanovichalexandr.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Александр on 12.06.2017.
 */
public class downloader implements downloaderInterface{
    private byte[] buffer;

    @Override
    public byte[] getFile(String pathToURL) throws IOException {
        URL connection = new URL(pathToURL);
        HttpURLConnection urlConnection;
        urlConnection = (HttpURLConnection) connection.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();
        InputStream in = urlConnection.getInputStream();

        int buffSize = in.available();
        buffer = new byte[buffSize];
        in.read(buffer);

        in.close();

        return buffer;
    }

    public downloader() {
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public char[] getBufferOfChars() {
        char[] chars = new char[this.buffer.length];
        for (int i=0;i<this.buffer.length;i++) {
            chars[i] = (char) this.buffer[i];
        }
        return chars;
    }
}
