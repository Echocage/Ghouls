package Ghouls.tasks;

import Ghouls.Ghouls;
import Ghouls.resources.Task;
import Ghouls.resources.Timer;
import org.powerbot.script.Condition;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;

import java.util.Random;


public class AntiBan extends Task<ClientContext> {

    Timer timer;
    Random rand = new Random();

    public AntiBan(ClientContext ctx) {
        super(ctx);
        timer = new Timer(rand.nextInt(10000));

    }


    @Override
    public boolean activate() {
        return !timer.isRunning();
    }

    @Override
    public void execute() {
        GameObject obj = ctx.objects.select().shuffle().first().poll();
        switch (1 + rand.nextInt(2)) {
            case 1:
                System.out.println("antiban 1");
                ctx.camera.turnTo(obj);
                break;
            case 2:
                System.out.println("antiban 3");
                Condition.sleep(1000);
                break;
        }
        timer = new Timer(5000 + rand.nextInt(10000));
    }
}