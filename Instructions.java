/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends State 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Instructions
     */
    public Instructions(SwimmyWorld w)
    {
        super(w);
    }

    public void onSet()
    {
        // put your code here
        int ww = getWorld().getWidth();
        int wh = getWorld().getHeight();

        Text a = new Text("CLICK THE GREEN BUTTON TO START");
        a.getImage().scale(590, 50);
        getWorld().addObject(a,getWorld().getWidth()/2, 20);

        Text b = new Text("Instructions:");
        getWorld().addObject(b,getWorld().getWidth()/2, 90);

        Text c = new Text("Press space to jump in between the rocks and gain 1 point. \n Eating food gives you 2 points. \n Don't swim too high or low, otherwise you will get trapped in the nets. \n The game is over when you crash into the rocks or touch one of the nets. \n Once you have clicked the green button, press space to start. \n Good luck!");
        c.getImage().scale(590, 140);
        getWorld().addObject(c,getWorld().getWidth()/2, 180);

        Button button = new Button();
        getWorld().addObject(button, getWorld().getWidth()/2, getWorld().getHeight()*4/5);

    
    }

    public void onRemove()
    {
        // put your code here
        getWorld().removeObjects(getWorld().getObjects(null));
    }

    public void onAct()
    {
        // put your code here
        if(getWorld().getstart()){
            getWorld().setState(new GameState(getWorld()));
        }
    }
}
