package Ghouls.tasks;

import Ghouls.resources.Paths;
import Ghouls.resources.Settings;
import Ghouls.resources.Task;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;


public class ToBank extends Task<ClientContext> {
    TilePath path;

    public ToBank(ClientContext ctx) {
        super(ctx);
        path = ctx.movement.newTilePath(Paths.bankToGhouls).reverse();
    }


    @Override
    public boolean activate() {
        return ctx.backpack.select().id(Settings.getFoodId()).count() <= Settings.getFoodCount() &&
                !ctx.bank.inViewport();
    }

    @Override
    public void execute() {
        System.out.println("Walking to bank");
        Paths.traversePath(ctx, path);
    }

}