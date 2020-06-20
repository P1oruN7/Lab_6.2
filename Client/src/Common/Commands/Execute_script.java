package Common.Commands;

import Common.Command;
import Common.Invoker;
import Readers.CommandArgumentSplitter;
import Readers.ConsoleSourceReader;
import Readers.FileSourceReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Команда "СКРИПТ"
 */

public class Execute_script implements Command {

    public Execute_script(){
        Invoker.regist("execute_script",this);
    }
    protected static ArrayList<String> usedFiles = new ArrayList<>();

    static boolean fileWork = true;
    /**
     * Метод для выполнения скрипта
     *
     * @param s2 имя файла
     * @return fileWork
     */

    public  void execute(String s2) {

//        if(s2 == null | s2.equals("")){
//            ConsoleSourceReader consoleSourceReader = new ConsoleSourceReader();
//            while (s2 == null | s2.equals("")) {
//                System.out.println("кажется, вы забыли ввести расположение файла. Где он лежит?");
//                s2 = consoleSourceReader.getLine();
//            }
//            System.out.println("спасибо, но в следующий раз введите его в той же строке, что и команду" + "\n");
//        }
//
//        if (theSameExist(s2)){
//            System.out.println("\n"+"-ать с рекурсией не надо игр-" +"\n");
//            System.out.println("Рекурсивное чтение файла было завершено во избежание разрыва пространственно-временного континуума.");
//        } else {
//            usedFiles.add(s2);
//            try {
//                FileSourceReader fileSourceReader = new FileSourceReader(s2);
//                String[] s;
//                String line;
//                line = fileSourceReader.getLine();
//                while (fileWork && line != null) {
//                    s = CommandArgumentSplitter.comArgSplitter(line);
//                    fileWork = Commander.switcher(fileSourceReader, c, s[0], s[1]);
//                    line = fileSourceReader.getLine();
//                }
//                fileSourceReader.close();
//                usedFiles.clear();
//                System.out.println("Завершение скрипта");
//            } catch (IOException e) {
//                System.out.println("ошибка чтения файла");
//                usedFiles.clear();
//            } catch (Exception e) {
//                System.out.println("непредвиденный конец файла");
//                usedFiles.clear();
//            }
//        }
//        return fileWork;

    }

    /**
     * Поиск передаваемого файла среди уже запущенных
     * @param s2 путь файла
     * @return true - если найден
     */
    private static boolean theSameExist (String s2){
        for (String s: usedFiles) if (s.equals(s2)) return true;
        return false;
    }


    @Override
    public String getInfo() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла.В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}