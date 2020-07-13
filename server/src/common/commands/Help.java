package common.commands;

import common.Command;
import common.Invoker;

/**
 * Команда "ПОМОЩЬ"
 */
public class Help implements Command {
    public Help() {
        Invoker.regist("help", this);
    }

    /**
     * Вывод описания всех команд
     */
    @Override
    public void execute(String s) {
//        System.out.println("\n \n \n");
//        for (Command command : getCommandCollection().values()) {
//            System.out.println(command.getInfo());
//        }
//        System.out.println("\n \n \n");
    }

    @Override
    public String getInfo() {
        return "help : вывести список всех команд и кратенько рассказать, что они делают";
    }
}
