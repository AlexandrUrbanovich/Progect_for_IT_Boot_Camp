package Progect_for_IT_Boot_Camp;

import Progect_for_IT_Boot_Camp.ru.mail.urbanovichalexandr.model.Task;
import Progect_for_IT_Boot_Camp.ru.mail.urbanovichalexandr.model.downloader;
import Progect_for_IT_Boot_Camp.ru.mail.urbanovichalexandr.model.taskFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App
{
    public static String ERROR_MESSAGE = "Входные параметры:\n" +
            "\n" +
            "  -f путь к файлу со списком ссылок\n" +
            "  -o имя папки, куда складывать скачанные файлы\n";


    public static void main(String[] args) {
        // проверим входные параметры
        //-f<путь к файлу> -o<имя папки>

        String pathToFile = "";
        String nameOfDir = "";

        if (args.length != 2) {
            System.out.printf(ERROR_MESSAGE);
            return;
        } else {
                pathToFile = String.valueOf(args[0].replaceAll("-", ""));
                nameOfDir = String.valueOf(args[1].replaceAll("-", ""));
           }


        System.out.printf("Путь к файлу: %s\n", pathToFile);
        System.out.printf("Имя папки: %s\n\n", nameOfDir);


        // проверим наличие файла (и его синтаксис), наличие папки
        taskFile taskFile = new taskFile(pathToFile); // TODO: проверка синтаксиса файла, а то можно понаписать...

        System.out.printf("Получены задания: \n");
        for (Task task : taskFile.getTasks()) {
            System.out.printf("Путь: %s в файл: %s\n", task.getPath(), task.getFileName());
        }
        System.out.printf("\n");

        File file = new File(nameOfDir);
        if (!file.exists() || !file.isDirectory()) {
            System.out.printf("Неверное имя папки для сохранения: %s", nameOfDir);
            return;
        }


        for (Task task : taskFile.getTasks()) {
            downloader dl = new downloader();
            try {
                dl.getFile(task.getPath());
            } catch (IOException exc) {
                System.out.printf("%s", exc.toString());
                return;
            }
            String pathToWriteFile = nameOfDir+"/"+task.getFileName();
            File fileToWrite = new File(pathToWriteFile);
            try {
                FileWriter writer = new FileWriter(fileToWrite);
                writer.write(dl.getBufferOfChars());
                writer.close();
            } catch (IOException e) {
                System.out.printf("%s", e.toString());
                return;
            }
            System.out.printf("Содержимое из: %s скачано и записано в файл: %s\n", task.getPath(), pathToWriteFile);
        }


    }
}
