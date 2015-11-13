package Ghouls.tasks;

import Ghouls.resources.Settings;
import Ghouls.resources.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.Filter;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;

import java.util.concurrent.Callable;


public class Attacking extends Task<ClientContext> {

    public Attacking(ClientContext ctx) {
        super(ctx);

    }

    public static int[] ghoulIds = {1218};

    @Override
    public boolean activate() {
        boolean ghoulsNearby = !ctx.npcs.select().id(ghoulIds).isEmpty();
        boolean hasFood = ctx.backpack.select().id(Settings.getFoodId()).count() > Settings.getFoodCount();
        boolean inCombat = ctx.players.local().interacting().valid();
        boolean inMotion = ctx.players.local().inMotion();
        return ghoulsNearby && hasFood && !inCombat && !inMotion;
    }

    @Override
    public void execute() {
        System.out.println("attacking");
        final Npc ghoul = ctx.npcs.select(new Filter<Npc>() {
            @Override
            public boolean accept(Npc npc) {
                return !npc.valid();
            }
        }).nearest().poll();
        if (!ghoul.inViewport()) {
            if (ctx.movement.distance(ghoul.tile()) > 15) {
                ctx.movement.findPath(ghoul).traverse();
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ghoul.inViewport();
                    }
                }, 200, 20);
            }
            ctx.camera.turnTo(ghoul);
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ghoul.inViewport();
                }
            }, 200, 5);
        }
        ghoul.interact("Attack");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().inCombat();
            }
        }, 500, 5);
    }
}