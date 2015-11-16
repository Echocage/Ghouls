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
        boolean ghoulsNearby = !ctx.npcs.select(new Filter<Npc>() {
            @Override
            public boolean accept(Npc npc) {
                return npc.animation() != 836;
            }
        }).id(ghoulIds).isEmpty();

        return ghoulsNearby && ctx.backpack.select().id(Settings.getFoodId()).count() > Settings.getFoodCount()
                && !ctx.players.local().inMotion() && !inCombat();
    }

    @Override
    public void execute() {
        System.out.println("Attacking");
        final Npc ghoul = ctx.npcs.poll();
        System.out.println(ghoul);
        if (!ghoul.inViewport()) {
            if (ctx.movement.distance(ghoul.tile()) > 15) {
                ctx.movement.findPath(ghoul).traverse();
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ghoul.inViewport();
                    }
                }, 200, 10);
            }
            ctx.camera.turnTo(ghoul);
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return ghoul.inViewport();
                }
            }, 200, 10);
        }
        ghoul.interact("Attack");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().inCombat();
            }
        }, 200, 10);
    }

    public boolean inCombat() {
        return ctx.players.local().inCombat() || (ctx.movement.distance(ctx.npcs.nearest().poll().tile()) < 3 && ctx.players.local().interacting().valid());
    }
}