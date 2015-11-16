package Ghouls.tasks;

import Ghouls.resources.Settings;
import Ghouls.resources.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

import java.util.concurrent.Callable;


public class Bank extends Task<ClientContext> {


    public Bank(ClientContext ctx) {
        super(ctx);

    }


    @Override
    public boolean activate() {
        return ctx.backpack.select().id(Settings.getFoodId()).count() <= Settings.getFoodCount() && ctx.bank.inViewport();
    }

    @Override
    public void execute() {
        System.out.println("Banking");
        if (!ctx.bank.opened()) {
            ctx.bank.open();
        }
        if (ctx.backpack.select().id(Settings.getFoodId()).count() <= Settings.getFoodCount()) {
            ctx.bank.withdraw(Settings.getFoodId(), 6);
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ctx.backpack.select().id(Settings.getFoodId()).count() > Settings.getFoodCount();
                }
            }, 500, 5);
        } else {
            ctx.bank.close();
        }
    }


}