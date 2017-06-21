package Progect_for_IT_Boot_Camp.ru.mail.urbanovichalexandr.model;

/**
 * Created by Александр on 12.06.2017.
 */
public class Task {
    private String path;
    private String fileName;

    public Task(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
