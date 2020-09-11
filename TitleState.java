/**
 * Write a description of class TitleState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class TitleState extends State 
{
    public TitleState(SwimmyWorld w){
        super(w);
    }

    public void onSet()
    {
        // put your code here
        int ww = getWorld().getWidth();
        int wh = getWorld().getHeight();


        Name name = new Name();
        name.getImage().scale(400, 100);
        getWorld().addObject(name,getWorld().getWidth()/2, 50);
        Text a = new Text("CLICK THE GREEN BUTTON TO START");
        a.getImage().scale(580, 50);
        getWorld().addObject(a,getWorld().getWidth()/2, 120);
        Text c = new Text("CLICK THE BLUE BUTTON FOR INSTUCTIONS");
        c.getImage().scale(600, 50);
        getWorld().addObject(c,getWorld().getWidth()/2, 170);
        Button button = new Button();
        getWorld().addObject(button, getWorld().getWidth()/2 + 80, getWorld().getHeight()*2/3);
        Button2 button2 = new Button2();
        getWorld().addObject(button2, getWorld().getWidth()/2 - 80, getWorld().getHeight()*2/3);
    }

    public void onRemove()
    {
        // put your code here
        getWorld().removeObjects(getWorld().getObjects(null));
    }

    public void onAct()
    {
        // put your code here

        // put your code here
        if(Greenfoot.isKeyDown("space")){
            getWorld().setState(new GameState(getWorld()));
        }

        // put your code here
        if(getWorld().getstart()){
            getWorld().setState(new GameState(getWorld()));
        }

        if(getWorld().getinstructions()){
            getWorld().setState(new Instructions(getWorld()));
        }
    }
}
