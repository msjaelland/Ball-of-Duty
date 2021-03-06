package application.engine.entities.specializations;

import application.engine.entities.BoDCharacter;
import application.engine.game_object.*;
import application.engine.game_object.physics.Physics;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

public class Heavy extends BoDCharacter
{
    private static final int HEALTH = 150;
    private static final int SPEED = 30;
    private static final int DAMAGE = 15;
    private static final int FIRE_RATE = 3;
    private static final int MAGAZINE_SIZE = 9;
    private static final double SIZE = 70;
   
 
    public Heavy(int id, Point2D position, Image image)
    {
        super(id);
        this.body = new Body(this, position, SIZE, SIZE, TYPE);
        this.physics = new Physics(this, SPEED);
        this.view = new View(this, image);
        this.weapon = new Weapon(this, FIRE_RATE, MAGAZINE_SIZE, DAMAGE);
        this.health = new Health(HEALTH);
    }
}