package Progect_for_IT_Boot_Camp.ru.mail.urbanovichalexandr.model;

import java.io.IOException;

/**
 * Created by Александр on 12.06.2017.
 */
public interface downloaderInterface {
    byte[] getFile(String pathToURL) throws IOException;
}
