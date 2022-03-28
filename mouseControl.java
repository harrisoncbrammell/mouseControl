/* 
This is a simple class that creates a thread which locks the mouse in a certain postion. 
It can take an x an y value as well as a sleep timer milisecond value to wait in between each check 
Starting the thread begins an infinate loop in which each iteration checks the mouse position against the intstances set x and y values and moves the mouse if needed. 
*/
package com.company;
import java.awt.*;
import static java.lang.Thread.sleep;

public class mouseControl extends Thread{
    int x;
    int y;
    int sleep;
    public mouseControl(int x, int y, int sleep) throws InterruptedException, AWTException {
        this.x = x;
        this.y = y;
        this.sleep = sleep;
    }
    public mouseControl(){
        this.x = MouseInfo.getPointerInfo().getLocation().x;
        this.y = MouseInfo.getPointerInfo().getLocation().y;
        sleep = 5000;
    }
    public mouseControl(int x, int y) {
        this.x = x;
        this.y = y;
        this.sleep = 500;
    }
    
    //checks the mouse position and moves it to a specified point if not already there
    private void lockMouse() throws AWTException, InterruptedException {
        Robot robby = new Robot();
        while(true){
            int yCheck = MouseInfo.getPointerInfo().getLocation().y;
            int xCheck = MouseInfo.getPointerInfo().getLocation().x;
            if(xCheck!=x||yCheck!=y){
                robby.mouseMove(x,y);
            }
            sleep(sleep);
            // Enable to print after each mouse location check loop iteration for debugging
            //System.out.print(" . ");
        }
    }
    public void run(){
        try {
            lockMouse();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }
}
