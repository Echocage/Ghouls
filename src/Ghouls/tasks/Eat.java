package Ghouls.tasks;

import Ghouls.resources.Settings;
import Ghouls.resources.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Hud;
import org.powerbot.script.rt6.Item;

import java.util.concurrent.Callable;


public class Eat extends Task<ClientContext> {

    public Eat(ClientContext ctx) {
        super(ctx);

    }


    @Override
    public boolean activate() {
        if (!ctx.hud.opened(Hud.Window.BACKPACK))
            ctx.hud.open(Hud.Window.BACKPACK);
        return ctx.backpack.select().id(Settings.getFoodId()).count() > 0 && ctx.players.local().healthPercent() < Settings.getEatPercent();
    }

    @Override
    public void execute() {
        Item food = ctx.backpack.poll();
        food.interact("Eat");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().healthPercent() > Settings.getEatPercent();
            }
        }, 200, 10);

    }
}