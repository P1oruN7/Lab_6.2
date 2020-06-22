package Utility;
import Common.Command;
import Common.FileRead;
import Common.Invoker;

import java.io.IOException;
import java.util.Scanner;
/**
 * The type Common.Commands.Utility.Save.
 */
public class Save implements Command {
    /**
     * Instantiates a new Common.Commands.Utility.Save.
     */
    public Save(){
        Invoker.regist("save",this);
    }
    @Override
    public void execute(String par1) throws IOException {
        SaveInFile saveInFile = new SaveInFile();
        saveInFile.Saving(new FileRead().getFilePath());
        System.out.println("Коллекция сохранена в изначальный файл");

    }
    @Override
    public String getInfo() {
        return "---> Сохранить коллекцию в исходный файл.";
    }
}
