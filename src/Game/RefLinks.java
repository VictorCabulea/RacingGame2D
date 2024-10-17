package Game;
import Game.entities.creatures.Player;
import Game.graphics.GameCamera;
import Game.physics.Speed;
import Game.worlds.World;

public class RefLinks {

    private Game game;
    private World world;

    public RefLinks(Game game){
        this.game=game;
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseInput getMouseInput(){
        return game.getMouseInput();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}