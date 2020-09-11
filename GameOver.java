/**
 * Write a description of class GameOver here.
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

//import java.util.List;
//import java.util.ArrayList;
//import java.util.Random;

public class GameOver extends State 
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class GameOver
     */
    public GameOver(SwimmyWorld w)
    {
        super(w);      
    }

    public void onSet()
    {
        // put your code here
        int ww = getWorld().getWidth();
        int wh = getWorld().getHeight();
        Over o = new Over();

        Text b = new Text("Press n to play again!");
        b.getImage().scale(250, 45);

        getWorld().addObject(o, ww/2, wh/2-15);
        getWorld().addObject(b,getWorld().getWidth()/2,
            getWorld().getHeight()*3/5);

    }

    public void onRemove()
    {
        getWorld().removeObjects(getWorld().getObjects(null));
    }

    public void onAct()
    {
        // put your code here
        if(Greenfoot.isKeyDown("n")){
            getWorld().setState(new TitleState(getWorld()));
        }
    }
}
