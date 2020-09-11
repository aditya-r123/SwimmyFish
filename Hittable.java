import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hittable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hittable extends Actor
{
    public void onHit()
    {
        // Add your action code here.
        destroy();
    }    

    public void destroy(){
        getWorld().removeObject(this);
    }
   
}
