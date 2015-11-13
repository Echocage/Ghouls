package Ghouls.tasks;

import Ghouls.Ghouls;
import Ghouls.resources.Settings;
import Ghouls.resources.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

import java.util.concurrent.Callable;


public class Eat extends Task<ClientContext> {

    public Eat(ClientContext ctx) {
        super(ctx);

    }



    @Override
    public boolean activate() {
        boolean hasFood = ctx.backpack.select().id(Settings.getFoodId()).count() > 0;
        boolean needHeal = ctx.players.local().healthPercent() < Settings.getEatPercent();
        return hasFood && needHeal;
    }

    @Override
    public void execute() {
        System.out.println("Eating");
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