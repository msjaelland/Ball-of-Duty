package application.engine.entities.specializations;

import application.engine.entities.BoDCharacter;
import application.engine.game_object.*;
import application.engine.game_object.physics.Physics;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Blaster extends BoDCharacter
{
    private static final int HEALTH = 100;
    private static final int SPEED = 100;
    private static final int DAMAGE = 5;
    private static final int FIRE_RATE = 10;
    private static final int MAGAZINE_SIZE = 30;
    private static final double SIZE = 50;
   
 
    public Blaster(int id, Point2D position, Image image)
    {
        super(id);
        this.body = new Body(this, position, SIZE, SIZE, TYPE);
        this.physics = new Physics(this, SPEED);
        this.view = new View(this, image);
        this.weapon = new Weapon(this, FIRE_RATE, MAGAZINE_SIZE, DAMAGE);
        this.health = new Health(HEALTH);
    }
}