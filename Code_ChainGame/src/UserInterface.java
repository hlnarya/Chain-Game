import java.awt.Color;
import java.util.Scanner;

import enigma.console.Console;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class UserInterface {
	
	int cursorX;
    int cursorY;
    public Console console;
    
    public UserInterface(String name, int width, int height, int fontSize){

        this.console = Enigma.getConsole(name, width, height, fontSize, 0);
    	this.cursorX = 5;
    	this.cursorY = 5;
    }
    
    public void setCursor(int x, int y) {
    	this.cursorX = x;
    	this.cursorY = y;
    }
    public int[] getCursor() {
    	int[] cursor = {this.cursorX , this.cursorY};
    	return cursor;
    	 
    }
    void displayElement(int row , int column , char element) {

        Color foregroundColor = Color.WHITE;
        Color backgroundColor = Color.BLACK;

        switch (element) {
            case '1':
                foregroundColor = Color.PINK;
                break;
            case '2':
                foregroundColor = Color.RED;
                break;
            case '3':
                foregroundColor = Color.GREEN;
                break;
            case '4':
                foregroundColor = Color.ORANGE;
                break;
            case '+':
            	if(this.cursorX==column && this.cursorY==row) {
            		backgroundColor = Color.WHITE;
            		foregroundColor = Color.RED;
            	}else
                foregroundColor = Color.RED;
                break;
            case ' ':
            	if(this.cursorX==column && this.cursorY==row) {
            		backgroundColor = Color.WHITE;
            		foregroundColor = Color.RED;
            	}
            		
                break;
            default:
                foregroundColor = Color.WHITE;
                break;
        }
        this.console.setTextAttributes(new TextAttributes(foregroundColor, backgroundColor));
        this.console.getTextWindow().setCursorPosition(column ,row );
        System.out.print(element);
        //this.console.getTextWindow().setCursorPosition(this.cursorX,this.cursorY);
    }
    public void clear(){

        for(int i = 0; i < console.getTextWindow().getRows(); i++)
          System.out.print("\n");

        console.getTextWindow().setCursorPosition(0, 0);
        
      }

	public void displayMenu() {
		Color foregroundColor = Color.WHITE;
        Color backgroundColor = Color.BLACK;
        String[] menu= {"Menu", "1-New Random Game", "2-New Game Entering Seed", "3-Highscore Table"};
		int[] diplayCursor = {10 , 5};
		int cursorY=this.cursorY;
		for(int i =0;i<4;i++) {
			if(cursorY==diplayCursor[1]&&diplayCursor[1]>5) {
				backgroundColor = Color.WHITE;
				foregroundColor = Color.BLACK;
			}else {
				backgroundColor = Color.BLACK;
				foregroundColor = Color.WHITE;
			}
			this.console.setTextAttributes(new TextAttributes(foregroundColor, backgroundColor));
	        this.console.getTextWindow().setCursorPosition(diplayCursor[0] ,diplayCursor[1] );
	        System.out.print(menu[i]);
	        diplayCursor[1]+=2;
	        
		}
		
		
			
		
	}

	public int displaySeedInput() {
		clear();
		Scanner scan = new Scanner(System.in);
		this.console.getTextWindow().setCursorPosition(10,9);
		System.out.println("Enter seed number: ");
		System.out.println("Tip: A seed number represents a board,");
		System.out.println("the seed number always the same board.");
		this.console.getTextWindow().setCursorPosition(30,9);
		int seedInput = scan.nextInt();
		scan.close();
		clear();
		return seedInput;
	}

	public void displaySideBoard(int seedID, int round, int score) {
		console.getTextWindow().setCursorPosition(35,0);
        console.getTextWindow().output("Board Seed : "+seedID);
        console.getTextWindow().setCursorPosition(35,1);
        console.getTextWindow().output("Round      : " + round);
        console.getTextWindow().setCursorPosition(35,2);
        console.getTextWindow().output("Score      : " + score);
        console.getTextWindow().setCursorPosition(35,3);
        console.getTextWindow().output("=====================================================");
        console.getTextWindow().setCursorPosition(35,4);
        console.getTextWindow().output("Table :");
	}

	public void endGameMessage() {
		Color foregroundColor = Color.WHITE;
        Color backgroundColor = Color.BLACK;
        String[] menu= {"Do You Want To continue?", "Yes", "No"};
		int[] diplayCursor = {10 , 5};
		int cursorY=this.cursorY;
		for(int i =0;i<3;i++) {
			if(cursorY==diplayCursor[1]&&diplayCursor[1]>5) {
				backgroundColor = Color.WHITE;
				foregroundColor = Color.BLACK;
			}else {
				backgroundColor = Color.BLACK;
				foregroundColor = Color.WHITE;
			}
			this.console.setTextAttributes(new TextAttributes(foregroundColor, backgroundColor));
	        this.console.getTextWindow().setCursorPosition(diplayCursor[0] ,diplayCursor[1] );
	        System.out.print(menu[i]);
	        diplayCursor[1]+=2;
	        
		}
	}

	public String displayScore() {
		clear();
		Scanner scan = new Scanner(System.in);
		this.console.getTextWindow().setCursorPosition(10,9);
		System.out.println("Enter Your Name: ");
		this.console.getTextWindow().setCursorPosition(30,9);
		String name = scan.next();
		clear();
		this.console.getTextWindow().setCursorPosition(10,9);
		System.out.println("Enter Your Surename: ");
		this.console.getTextWindow().setCursorPosition(30,9);
		String sureName = scan.next();
		scan.close();
		clear();
		
		return new String(name+" "+sureName);
	}
}
