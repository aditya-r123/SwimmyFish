import greenfoot.*;

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class BottomRock extends Actor
{
    
    
    
    
    /**
     * Act - do whatever the Pipe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        setLocation(getX() - 4, getY());
        getImage().scale(50, 240);
        
    }    
}
