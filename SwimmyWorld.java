import greenfoot.*;

/**
 * Write a description of class SwimmyWorld here.
 * 
 * @author
 * @version
 */
public class SwimmyWorld extends World
{
    private int score = 0;
    private Text text = new Text("");
    private State state;
    private boolean isdead = false;
    private boolean isstart = false;
    private boolean isinstructions = false;
    /**
     * Constructor for objects of class SwimmyWorld.
     * 
     */
    
    public SwimmyWorld()
    {            
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);         
        setState(new TitleState(this));              
    }
    
    public void act()
    {
        state.onAct();
    }
    
    public int getScore (){
        return score;
    }

    public void setScore(int a){
        score = a;
        setScoreText(text);
        
    }
    
    public Text getText (){
        return text;
    }
    
    public void setScoreText(Text a ){
        a.settextName(Integer.toString(score));
        a.updateImage();
    }
    
    public void setState(State s){
        if(state != null){
            state.onRemove();
        }
        state = s;
        state.onSet();
    }
    
    public boolean getdead (){
        return isdead;
    }
    
    public void setDead (){
        isdead = !isdead;
    }
    
    public boolean getstart(){
        return isstart;
    }
    
    public void setStart(){
        isstart = !isstart;        
    }
    
    public boolean getinstructions(){
        return isinstructions;
    }
    
    public void setInstructions(){
        isinstructions = !isinstructions;        
    }
}
