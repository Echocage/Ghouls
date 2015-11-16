package Ghouls.resources;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.TilePath;

import java.util.concurrent.Callable;

/**
 * Created by echo on 11/4/15.
 */
public class Paths {
    public static final Tile[] bankToGhouls = new Tile[]{
            new Tile(3511, 3480, 0),
            new Tile(3505, 3482, 0),
            new Tile(3500, 3483, 0),
            new Tile(3496, 3483, 0),
            new Tile(3491, 3483, 0),
            new Tile(3486, 3480, 0),
            new Tile(3481, 3478, 0),
            new Tile(3477, 3476, 0),
            new Tile(3473, 3474, 0),
            new Tile(3468, 3475, 0),
            new Tile(3463, 3479, 0),
            new Tile(3459, 3483, 0),
            new Tile(3455, 3486, 0),
            new Tile(3451, 3490, 0),
            new Tile(3448, 3494, 0),
            new Tile(3445, 3497, 0),
            new Tile(3440, 3498, 0),
            new Tile(3436, 3499, 0),
            new Tile(3431, 3501, 0),
            new Tile(3426, 3502, 0),
            new Tile(3421, 3505, 0),
            new Tile(3417, 3507, 0)
    };


    public static void traversePath(final ClientContext ctx, TilePath path) {
        boolean canTraverse = path.traverse();
        if (!canTraverse) {
            Tile tile = path.next();
            if (tile != null)
                ctx.movement.step(path.next());
        }
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.movement.distance(ctx.movement.destination()) < 15;
            }
        }, 500, 5);
    }
}
