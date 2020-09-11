import greenfoot.*;

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SwimmyFish extends Actor
{
    double dy = 0;
    double g = .3;
    double BOOST_SPEED = -3.5;
    int clicks = 0;
   // GreenfootSound xyz = new GreenfootSound("woosh.mp3");
    public void act() 
    {
        
        SwimmyWorld sw = (SwimmyWorld)(getWorld());

        if(getOneIntersectingObject(BottomRock.class) !=null || getOneIntersectingObject(TopRock.class) !=null){
            sw.setDead();
            Greenfoot.playSound("thunk.wav");
        }
        
        if(clicks == 0){
            setLocation(getX(), getY());
        }
        if(Greenfoot.isKeyDown("space")||Greenfoot.isKeyDown("up")){
            clicks++;
        }
        
        if(clicks>=1){
            setLocation( getX(),(int)(getY() +dy));
            if(Greenfoot.isKeyDown("up") == true ){
                dy= BOOST_SPEED;

            }
            if(Greenfoot.isKeyDown("space") == true ){
               
                dy= BOOST_SPEED;
            }
            if((dy >-8) && (dy < 7)){
                setRotation(-30);
            }else if(dy >= 0){
                setRotation(30); 
            }
           
            if(getY() > getWorld().getHeight()-30 || getY() < 30){
                Greenfoot.playSound("splash2.wav");
                sw.setDead();
            }
            dy = dy+g;
        }
        
        Actor fish = getOneIntersectingObject(Food.class);
        if(fish != null)
        {
            sw.removeObject(fish);
            Greenfoot.playSound("beep.wav");
            sw.setScore(sw.getScore() + 2);
        }
    } 

    public int getYValue(){
        return getY();
    }
}
