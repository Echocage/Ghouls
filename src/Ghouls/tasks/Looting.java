package Ghouls.tasks;

import Ghouls.Ghouls;
import Ghouls.resources.Settings;
import Ghouls.resources.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GroundItem;
import org.powerbot.script.rt6.GroundItemQuery;

import java.util.concurrent.Callable;


public class Looting extends Task<ClientContext> {


    public Looting(ClientContext ctx) {
        super(ctx);

    }


    @Override
    public boolean activate() {
        boolean charmOnGround = !ctx.groundItems.select().id(Settings.getCharmsToLoot()).isEmpty();
        boolean hasFood = ctx.backpack.select().id(Settings.getFoodId()).count() > Settings.getFoodCount();
        boolean invFull = ctx.backpack.count() == 28;
        return charmOnGround && hasFood && !invFull;
    }

    @Override
    public void execute() {
        GroundItemQuery<GroundItem> charm = ctx.groundItems.select().id(Settings.getCharmsToLoot()).nearest();
        for (final GroundItem groundItem : charm) {
            if (!groundItem.inViewport()) {
                ctx.camera.turnTo(groundItem);
                if (!Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return groundItem.inViewport();
                    }
                }, 200, 5)) {
                    ctx.movement.step(groundItem);
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return groundItem.inViewport();
                        }
                    }, 200, 20);
                }
            }
            if (groundItem.inViewport()) {
                if (!groundItem.interact("Take")) {
                    return;
                }
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return !groundItem.valid();
                    }
                }, 500, 20);
                Ghouls.charmsPicked += 1;

            }
        }
    }
}