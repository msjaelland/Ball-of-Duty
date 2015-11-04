package application.engine.entities;

import application.engine.game_object.Body;
import application.engine.game_object.GameObject;
import application.engine.game_object.View;
import application.engine.game_object.physics.Physics;
import application.util.Timer;
import application.util.Vector2;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;

/**
 * A bullet can damage other objects with health.
 * 
 * @author Gruppe6
 *
 */
public class Bullet extends GameObject
{

    public enum Type
    {
        RIFLE, PISTOL
    }

    private final Type type;
    double damage;
    private Timer timer;
    private int lifeTime;
    public static final Body.Geometry BODYTYPE = Body.Geometry.CIRCLE;
    
   

    /**
     * Creates a bullet with a body, physics, view and damage.
     * 
     * @param id
     *            The id of the bullet.
     * @param position
     *            The starting position of the bullet.
     * @param height
     *            The height of the bullet.
     * @param width
     *            The width of the bullet.
     * @param velocity
     *            The velocity of the bullet.
     * @param damage
     *            The amount of health reduced on another object if this bullet collides with the object.
     */
    public Bullet(int id, Point2D position, double height, double width, Vector2 velocity, double damage, Type type, Image image)
    {
        super(id);
        this.type = type;
        this.damage = damage;
        this.setBody(new Body(this, position, height, width, BODYTYPE));
        this.setPhysics(new Physics(this, velocity.getMagnitude()));
        getPhysics().setVelocity(velocity);
        this.view = new View(this, image);
        lifeTime = 5;
        new Thread(() ->
        {
            timer = new Timer();
            timer.start();
            while ((timer.getDuration() < 1000 * lifeTime))
            {
                try
                {
                    Thread.sleep(20);
                }
                catch (Exception e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            setChanged();
            notifyObservers();
        }).start();
        ;

    }

    /**
     * Gets the damage of this bullet. I.e The amount of health reduced on another object if this bullet collides with the object.
     * 
     * @return
     */
    public double getDamage()
    {
        return damage;
    }

    /**
     * Gets the type of bullet.
     * @return The type of bullet.
     */
    public Type getType()
    {
        return this.type;
    }
}