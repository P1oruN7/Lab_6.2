package Common.Commands;

import Common.Command;
import Common.Invoker;

public class Draw implements Command {
    private static final long serialVersionUID = 6529685098267757690L;

    public Draw() {
        Invoker.regist("draw", this);
    }

    @Override
    public String getInfo() {
        return "draw: нарисовать случайного котика";
    }

    @Override
    public void execute(String s) {
    }
}
