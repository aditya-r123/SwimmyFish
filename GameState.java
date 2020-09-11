
import greenfoot.*;
/**
 * Write a description of class GameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameState extends State 
{
    // instance variables - replace the example below with your own
    private int x;
    int pipeCounter = 0;
    int PIPE_SPACING = 210;
    int swimmyCounter = 0;
    private int score = 0;
    int FIRST_POINT = 240;
    private Text text = new Text("");

    int clicks = 0;

    /**
     * Constructor for objects of class GameState
     */
    public GameState(SwimmyWorld w)
    {
        super(w);
    }
    SwimmyWorld sw = (SwimmyWorld)(getWorld());
    public void onSet()
    {
        sw.setScore(0);
        getWorld().addObject(sw.getText(),sw.getText().getImage().getWidth(), sw.getText().getImage().getHeight());

        //Create a swimmy bird object
        SwimmyFish swimmy = new SwimmyFish();
                swimmy.getImage().scale(30, 30);

        //Add swimmy to world
        sw.addObject(swimmy, 100, sw.getHeight()/2-50);
        sw.setPaintOrder(Text.class, TopRock.class, BottomRock.class, Food.class);
        for(int i = 0; i<=19; i++){
            Net net = new Net();
            net.getImage().scale(30, 30);
            net.getImage().rotate(90);
            getWorld().addObject(net, 2*i*net.getImage().getWidth()/2 + net.getImage().getWidth()/2, net.getImage().getHeight()/2);
        }
        for(int i = 0; i<=19; i++){
            Net net = new Net();
            net.getImage().scale(30, 30);
            net.getImage().rotate(-90);
            getWorld().addObject(net, 2*i*net.getImage().getWidth()/2 + net.getImage().getWidth()/2, getWorld().getHeight()-net.getImage().getHeight()/2);
        }
    }
    

    public void onRemove()
    {
        // put your code here        
        getWorld().removeObjects(getWorld().getObjects(null));
    }

    public void onAct()
    {
        if(Greenfoot.isKeyDown("space")){
            clicks++;
        }        
        pipeCounter++;
        if (pipeCounter % 100 == 0 && clicks != 0)
        {
            //Create a pipe object
            BottomRock br = new BottomRock();
            TopRock tr = new TopRock();

            GreenfootImage imageTwo = tr.getImage();
            GreenfootImage image = br.getImage();
            sw.addObject(tr, sw.getWidth(), sw.getHeight()-Greenfoot.getRandomNumber(55));
            sw.addObject(br, sw.getWidth(), sw.getHeight()/2 + image.getHeight()/2 + Greenfoot.getRandomNumber(30) + 20 );//+++++
            tr.setLocation(br.getX(), br.getY() - br.getImage().getHeight() - PIPE_SPACING );
        }

        if(pipeCounter % 50 == 0 && clicks != 0){
            Food f = new Food();
            GreenfootImage foodImg = new Food().getImage();
            for(int i = 0; i<1; i++){
                sw.addObject(f, sw.getWidth(), 40+Greenfoot.getRandomNumber(300));

                if(getWorld().getObjectsAt( foodImg.getWidth()/2 + (foodImg.getWidth()), foodImg.getHeight()*3/2 +(foodImg.getHeight()), BottomRock.class).isEmpty()){
                    sw.addObject(f, sw.getWidth(), 40+Greenfoot.getRandomNumber(300));
                }else{
                    i--;
                }                       
            }
        }
        
        if(swimmyCounter % 100 == 0 && clicks != 0)
        {
            sw.setScore(sw.getScore() + 1);  
            Greenfoot.playSound("woosh.mp3");
        }            
        swimmyCounter++;             
        
        if(getWorld().getdead()){
            getWorld().setDead();
            getWorld().setState(new GameOver(getWorld()));
        }
    }
}

