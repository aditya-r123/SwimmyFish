import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String textName;
    private int size;
    private Color textColor;
    private Color backgroundColor;
    private Color outlineColor;
    boolean alignleft = false;
    boolean alignright = false;
    boolean center = false;
    public Text(String string){
        textName = string;
        size = 40;
        Color textColor = new Color(0, 0, 0);
        GreenfootImage a = new GreenfootImage(textName, size, textColor, backgroundColor);
        setImage(a);
    }

    public void  updateImage() {
        GreenfootImage a = new GreenfootImage(textName, size, textColor, backgroundColor, outlineColor);
        setImage(a);  
    }

    public String gettextName(){
        return textName;
    }

    public void settextName (String a){
        textName = a;
        updateImage();

    }

    public void aline(int a){
        if(a == 1){
            setLocation(getWorld().getWidth() - getImage().getWidth()/2, getY());
        }else if (a == 2){
            setLocation( getImage().getWidth()/2, getY());
        }else if (a ==3){
            setLocation(getWorld().getWidth()/2 - getImage().getWidth()/2, getY());
        }
    }

    public int gettextsize(){
        return size;
    }

    public void settextsize(int a){
        size = a;
        updateImage();
    }

    public Color gettextColor(){
        return textColor;
    }

    public void settextColor (Color a){
        textColor = a;
        updateImage();
    }

    public Color getbackgroundColor(){
        return backgroundColor;
    }

    public void setbackgroundColor(Color a){
        backgroundColor = a;
        updateImage();
    }

    public Color getoutlineColor(){
        return outlineColor;
    }

    public void setoutlineColor(Color a){
        outlineColor = a;
        updateImage();
    }

    public void act() 
    {
        // Add your action code here.
    } 
}
