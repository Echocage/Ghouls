package Ghouls.tasks;

import Ghouls.resources.Paths;
import Ghouls.resources.Settings;
import Ghouls.resources.Task;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;


public class ToGhouls extends Task<ClientContext> {
    TilePath path = null;

    public ToGhouls(ClientContext ctx) {
        super(ctx);
        path = ctx.movement.newTilePath(Paths.bankToGhouls);

    }


    @Override
    public boolean activate() {
        return ctx.backpack.select().id(Settings.getFoodId()).count() > Settings.getFoodCount() &&
                ctx.npcs.select().id(Attacking.ghoulIds).isEmpty();
    }

    @Override
    public void execute() {
        System.out.println("Walking to ghouls");
        Paths.traversePath(ctx, path);
    }
}