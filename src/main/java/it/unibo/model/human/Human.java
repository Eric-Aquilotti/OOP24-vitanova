package it.unibo.model.human;

import it.unibo.common.Circle;
import it.unibo.common.Position;
import it.unibo.view.sprite.Sprite;

/**
 * Models a human that can move inside the map.
 */
public interface Human {

    /**
     * 
     * Moves the human by changing the position according to its direction and
     * speed.
     */
    void move();

    /**
     * 
     * @return the current position of the human.
     */
    Position getPosition();

    /**
     * 
     * @return the relative sprite.
     */
    Sprite getSprite();

    /**
     * 
     * @param other the human to collide with.
     * @return if the collision happens.
     */
    boolean collide(Human other);

    /**
     * 
     * @return the circle representing the reproduction area.
     */
    Circle getReproductionArea();
}
