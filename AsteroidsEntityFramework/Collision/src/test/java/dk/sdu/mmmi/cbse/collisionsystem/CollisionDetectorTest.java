package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.*;
import dk.sdu.mmmi.cbse.collisionsystem.CollisionDetector;

import static org.junit.jupiter.api.Assertions.*;

class   CollisionDetectorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void process() {
    }

    @DisplayName("Test that colliding works")
    @Nested
    class TestColliding{

        private Entity entity1;
        private Entity entity2;
        private CollisionDetector dectector;

        @BeforeEach()
        void setup(){
            entity1 = new Entity();
            entity2 = new Entity();
            entity1.setRadius(1.0f);
            entity2.setRadius(1.0f);
            dectector = new CollisionDetector();
        }

        @Test
        @DisplayName("Check that two entities that are far apart don't collide")
        void doesNotCollide() {
            entity1.add(new PositionPart(5.0f, 5.0f, 2.0f));
            entity2.add(new PositionPart(8.0f, 8.0f, 2.0f));
            assertFalse(dectector.collides(entity1, entity2));
            System.out.println("The methods doesNotCollide() is: doesn't collide");
        }

        @Test
        @DisplayName("Check that two entities on top of eachother collide")
        void doesCollide(){
            entity1.add(new PositionPart(100.0f, 100.0f, 2.0f));
            entity2.add(new PositionPart(100.0f, 100.0f, 2.0f));
            assertTrue(dectector.collides(entity1, entity2));
            System.out.println("The methods doesCollide() is: does collide");
        }
    }


}