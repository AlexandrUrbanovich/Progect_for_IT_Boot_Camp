package Progect_for_IT_Boot_Camp.ru.mail.urbanovichalexandr.model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Александр on 12.06.2017.
 */
public class taskFile {
    private String fileName;
    private ArrayList<Task> tasks;

    public taskFile(String fileName) {
        this.fileName = fileName;
        this.tasks = new ArrayList<Task>();

        File taskFile = new File(fileName);
        if (taskFile.exists() && taskFile.isFile()) {
            try {
                FileReader reader = new FileReader(taskFile);
                char[] buffer = new char[(int)taskFile.length()];
                reader.read(buffer);
                parse(buffer);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void parse(char[] buffer) {
        String fileAsString = new String(buffer);
        String[] words = fileAsString.trim().replaceAll("\r", " ").split(" ");
        for (int i=0;i<words.length-1;i+=2) {
            Task task = new Task(words[i], words[i+1]);
            tasks.add(task);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
