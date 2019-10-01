package com.bowling.bowling;

import com.bowling.bowling.util.Shoot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShootTest {

    @Test
    public void testFirstShoot() {
        int myNum = Shoot.shoot(0, 10);

        assertTrue(myNum >= 0 && myNum <= 10);
    }

    @Test
    public void testSecondShoot() {
        int myNum = Shoot.shoot(5, 10);

        assertTrue(myNum >= 5 && myNum <= 10);
    }

    @Test
    public void testShootBonus() {
        int myNum = Shoot.shootBonus();

        assertTrue(myNum >= 0 && myNum <= 10);
    }
}
