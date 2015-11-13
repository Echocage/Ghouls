package Ghouls;

import Ghouls.resources.Task;
import Ghouls.tasks.Attacking;
import Ghouls.tasks.Bank;
import Ghouls.tasks.Eat;
import Ghouls.tasks.Looting;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Script.Manifest(name = "Ghouls", description = "")
public class Ghouls extends PollingScript<ClientContext> implements PaintListener {
    private List<Task> taskList = new ArrayList<Task>();

    private final int START_XP = getTotalXp();
    final long START_TIME = System.currentTimeMillis();
    public static Gui gui;
    public static boolean guiFinished = false;
    public static int charmsPicked = 0;

    public void start() {
        taskList.addAll(Arrays.asList(new Attacking(ctx), new Eat(ctx), new Bank(ctx), new Looting(ctx)));
        startGui();
    }


    @Override
    public void poll() {
        for (Task task : taskList) {
            if (guiFinished && task.activate()) {
                task.execute();
            }
        }
    }

    public void startGui() {
        gui = new Gui();
        gui.frame1.setVisible(true);

    }

    public int getTotalXp() {
        final int[] experiences = ctx.skills.experiences();
        int sum = 0;
        for (int i : experiences)
            sum += i;
        return sum;
    }

    @Override
    public void repaint(Graphics graphics) {
        if (gui != null) {
            long milliseconds = System.currentTimeMillis() - START_TIME;
            int seconds = (int) (milliseconds / 1000) % 60;
            int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
            int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
            gui.labelUptime.setText(String.format("%d:%d:%d", hours, minutes, seconds));


            int gainedXp = getTotalXp() - START_XP;
            gui.labelXp.setText(String.format("%d", gainedXp));
            gui.labelXpHour.setText(String.format("(%d)", gainedXp * 3600000L / milliseconds));
            gui.labelCharms.setText(String.valueOf(charmsPicked));
            gui.labelCharmsHour.setText(String.format("(%d)", charmsPicked * 3600000L / milliseconds));

        }
    }
}