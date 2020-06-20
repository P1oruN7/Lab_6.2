package Common.Commands;

import Common.Command;
import Common.Invoker;

public class Draw implements Command {
    public Draw(){
        Invoker.regist("draw",this);
    }


    @Override
    public String getInfo(){return "draw: нарисовать случайного котика";}

    @Override
    public void execute(String s){
    }
}
