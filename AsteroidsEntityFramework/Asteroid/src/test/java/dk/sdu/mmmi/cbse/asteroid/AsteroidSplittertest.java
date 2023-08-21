package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsteroidSplittertest {

    private AsteroidSplitterImpl asteroidSplitter;
    private World world;

    @BeforeEach
    public void setup() {
        asteroidSplitter = new AsteroidSplitterImpl();
        world = new World();
    }

    @Test
    @DisplayName("Check that asteroid splits to two asterroids")
    public void testCreateSplitAsteroid() {
        Entity asteroid = new Asteroid();
        PositionPart positionPart = new PositionPart(0, 0, 0);
        LifePart lifePart = new LifePart(3);
        asteroid.add(positionPart);
        asteroid.add(lifePart);

        asteroidSplitter.createSplitAsteroid(asteroid, world);

        assertEquals(2, world.getEntities().size());
        System.out.println("Two new asteroids created");
    }

}
