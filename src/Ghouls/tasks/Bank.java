package Ghouls.tasks;

import Ghouls.Ghouls;
import Ghouls.resources.Paths;
import Ghouls.resources.Settings;
import Ghouls.resources.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

import java.util.concurrent.Callable;


public class Bank extends Task<ClientContext> {

    TilePath path = null;

    public Bank(ClientContext ctx) {
        super(ctx);

    }


    @Override
    public boolean activate() {
        boolean hasFood = ctx.backpack.select().id(Settings.getFoodId()).count() > Settings.getFoodCount();
        boolean nearGhouls = !ctx.npcs.select().id(Attacking.ghoulIds).isEmpty();
        return !hasFood || !nearGhouls;
    }

    @Override
    public void execute() {
        System.out.println("Banking");
        boolean hasFood = ctx.backpack.select().id(Settings.getFoodId()).count() > Settings.getFoodCount();
        if (hasFood) {
            System.out.println("Going to Theaving");
            goToGhouls();
        } else {
            if (ctx.bank.inViewport()) {
                handleBanking();
            } else {
                goToBank();
            }
        }
    }

    public void goToGhouls() {
        if (path == null || path.array()[0] == Paths.bankToGhouls[Paths.bankToGhouls.length - 1]) {
            path = ctx.movement.newTilePath(Paths.bankToGhouls);
        }
        walk();

    }

    public void goToBank() {
        if (path == null || path.array()[0] == Paths.bankToGhouls[0]) {
            path = ctx.movement.newTilePath(Paths.bankToGhouls).reverse();
        }
        walk();
    }

    public void walk() {
        boolean canTraverse = path.traverse();
        if (!canTraverse) {
            if (path.next() != null)
                ctx.movement.step(path.next());
        }
        waitTillNearDest();
    }

    public boolean waitTillNearDest() {
        return Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.movement.distance(ctx.movement.destination()) < 15;
            }
        }, 500, 5);

    }

    public void handleBanking() {
        if (!ctx.bank.opened()) {
            ctx.bank.open();
        }
        if (ctx.backpack.select().id(Settings.getFoodId()).count() <= Settings.getFoodCount()) {
            if (!ctx.backpack.isEmpty()) {
                ctx.bank.depositInventory();
            }
            ctx.bank.withdraw(Settings.getFoodId(), org.powerbot.script.rt6.Bank.Amount.ALL);
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