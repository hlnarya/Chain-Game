import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class ChainGame {
    // Game constants
	private static final int WINDOW_WIDTH = 90;
    private static final int WINDOW_HEIGHT = 26;
    private static final String SOFTWARE_NAME = "CHAIN GAME";
    private static final int FONT_SIZE = 19;
    // Width and height of the game field.
    private static final int HEIGHT = 19;
    private static final int WIDTH = 31;
    private Element[][] element;
    private boolean gameOver = false;
    private int seedID;
    private UserInterface ui;
	public KeyListener keyListener;
    private int keyPressed = 0;
    private int keyCode = 0;
    private int menuSelector;
    private int plusCount;
    private int round =1;
    private int score =0;
    int endGame;
    private SingleLinkedList chain;
    private MultiLinkedList table;
    private DoublyLinkedList highScore;
    public ChainGame() throws Exception {
    	/*
    	this.element = new Element[HEIGHT][WIDTH];
        this.ui = new UserInterface(SOFTWARE_NAME, WINDOW_WIDTH, WINDOW_HEIGHT, FONT_SIZE);
        ui.console.getTextWindow().addKeyListener(keyListener);
        this.menuSelector=-1;
        this.endGame = -1;
        this.plusCount = 0;
        this.table = new MultiLinkedList();
        this.highScore = new DoublyLinkedList();
        */
    }
    public void initGame()
    {
    	this.score = 0; 
    	this.highScore = new DoublyLinkedList();
    	this.element = new Element[HEIGHT][WIDTH];
        this.ui = new UserInterface(SOFTWARE_NAME, WINDOW_WIDTH, WINDOW_HEIGHT, FONT_SIZE);
        ui.console.getTextWindow().addKeyListener(keyListener);
        this.menuSelector=-1;
        this.endGame = -1;
        this.plusCount = 0;
        this.table = new MultiLinkedList();
    	while(this.menuSelector<0) {
    		ui.displayMenu();
    		keyListener=new KeyListener() {
                public void keyTyped(KeyEvent e) {}
                public void keyPressed(KeyEvent e) {
                   if(keyPressed==0) {
                	   keyPressed=1;
                	   keyCode=e.getKeyCode();
                   }
                }
                public void keyReleased(KeyEvent e) {}
             };
             ui.console.getTextWindow().addKeyListener(keyListener);
            // Handle player inputs
            if (this.keyPressed==1) {
                // Handle player inputs
                switch (this.keyCode) {
                    case KeyEvent.VK_DOWN:
                    	if(ui.getCursor()[1]<11)
                    		ui.setCursor(ui.getCursor()[0], ui.getCursor()[1]+2);
                        break;
                    case KeyEvent.VK_UP:
                    	if(ui.getCursor()[1]>7)
                            ui.setCursor(ui.getCursor()[0], ui.getCursor()[1]-2);
                        break;
                    case KeyEvent.VK_ENTER:
                    	switch(ui.getCursor()[1]) {
                    	case 7:
                    		this.menuSelector=1;
                    		break;
                    	case 9:
                    		this.menuSelector=2;
                    		break;
                    	case 11:
                    		this.menuSelector=3;
                    		break;
                    	default:
                    		this.menuSelector=-1;
                            break;
                    	}
                        break;
                    default:
                    	
                        break;
                }
                this.keyPressed=0;
            }
            try {
    			Thread.sleep(50);
    		} catch (InterruptedException e) {
    			// 
    			e.printStackTrace();
    		}
            ui.clear();
    	}
    	switch(menuSelector) {
    	case 1:
    		ui.setCursor(5, 5);
        	Random randomID = new Random();
        	this.seedID = randomID.nextInt(10000);
        	Random random = new Random(this.seedID);
        	int randomNumber = 0;
			for(int i = 0 ; i < HEIGHT ; i += 2) {
				for(int j = 0 ; j < WIDTH ; j += 2) {
					randomNumber = random.nextInt(4);
					switch (randomNumber) {
					case 0 :
						this.element[i][j] = new Element(i, j, '1');
						break;
					case 1 :
						this.element[i][j] = new Element(i, j, '2');
						break;
					case 2 :
						this.element[i][j] = new Element(i, j, '3');
						break;
					case 3 :
						this.element[i][j] = new Element(i, j, '4');
						break;
					}
					if(i<(HEIGHT-1) && j<(WIDTH-1)){
						this.element[i+1][j] = new Element(i+1, j, ' ');
						this.element[i+1][j+1] = new Element(i+1, j+1, ' ');
						this.element[i][j+1] = new Element(i, j+1, ' ');
					}
					if(i==(HEIGHT-1)&&j<(WIDTH-1)) {
						this.element[i][j+1] = new Element(i, j+1, ' ');
					}
						
					if(i<(HEIGHT-1) && j==(WIDTH-1))
						this.element[i+1][j] = new Element(i+1, j, ' ');
				}
			}
            for(int i = 0 ; i < HEIGHT ; i++) {
            	for(int j = 0 ; j < WIDTH ; j++) {
            			ui.displayElement(i, j, element[i][j].getElement());
            	}
            }
    		break;
    	case 2:
    		this.seedID = 10001;
    		do {
    			ui.setCursor(5, 5);
        		this.seedID = ui.displaySeedInput();
        		ui.clear();
    		}while(this.seedID>9999);
    		Random randomSeed = new Random(this.seedID);
        	int randomNumberSeed = 0;
			for(int i = 0 ; i < HEIGHT ; i += 2) {
				for(int j = 0 ; j < WIDTH ; j += 2) {
					randomNumberSeed = randomSeed.nextInt(4);
					switch (randomNumberSeed) {
					case 0 :
						this.element[i][j] = new Element(i, j, '1');
						break;
					case 1 :
						this.element[i][j] = new Element(i, j, '2');
						break;
					case 2 :
						this.element[i][j] = new Element(i, j, '3');
						break;
					case 3 :
						this.element[i][j] = new Element(i, j, '4');
						break;
					}
					if(i<(HEIGHT-1) && j<(WIDTH-1)){
						this.element[i+1][j] = new Element(i+1, j, ' ');
						this.element[i+1][j+1] = new Element(i+1, j+1, ' ');
						this.element[i][j+1] = new Element(i, j+1, ' ');
					}
					if(i==(HEIGHT-1)&&j<(WIDTH-1)) {
						this.element[i][j+1] = new Element(i, j+1, ' ');
					}
						
					if(i<(HEIGHT-1) && j==(WIDTH-1))
						this.element[i+1][j] = new Element(i+1, j, ' ');
				}
			}
            for(int i = 0 ; i < HEIGHT ; i++) {
            	for(int j = 0 ; j < WIDTH ; j++) {
            			ui.displayElement(i, j, element[i][j].getElement());
            	}
            }
    		
    		
            break;
    	case 3:
    		showHighScoreTable();
    		break;
    	}
    	if(menuSelector!=3) {
    		this.gameOver = false;
        	runGame();
    	}else {
    		try {
    			Thread.sleep(5000);
    		} catch (InterruptedException e) {
    			// 
    			e.printStackTrace();
    		}
    		initGame();
    	}
    	
    }

	public void runGame()
    {
        while(!this.gameOver)
        {
            //updating playground  
            ui.displaySideBoard(seedID, round, score);
            //---------------------------------------------------------------------------------------------------
            keyListener=new KeyListener() {
                public void keyTyped(KeyEvent e) {}
                public void keyPressed(KeyEvent e) {
                   if(keyPressed==0) {
                	   keyPressed=1;
                	   keyCode=e.getKeyCode();
                   }
                }
                public void keyReleased(KeyEvent e) {}
             };
             ui.console.getTextWindow().addKeyListener(keyListener);
            // Handle player inputs
            if (this.keyPressed==1) {
                // Handle player inputs
                switch (this.keyCode) {
                	case KeyEvent.VK_E:
                		gameOver = true;
                		ui.clear();
                		break;
                    case KeyEvent.VK_RIGHT:
                    	if(ui.getCursor()[0]<WIDTH-1&&(this.element[ui.getCursor()[1]][ui.getCursor()[0]+1].getElement()==' '||this.element[ui.getCursor()[1]][ui.getCursor()[0]+1].getElement()=='+'))
                    		ui.setCursor(ui.getCursor()[0]+1, ui.getCursor()[1]);
                    	else if(ui.getCursor()[0]<WIDTH-2&&(this.element[ui.getCursor()[1]][ui.getCursor()[0]+1].getElement()!=' '&&this.element[ui.getCursor()[1]][ui.getCursor()[0]+1].getElement()!='+'))
                    		ui.setCursor(ui.getCursor()[0]+2, ui.getCursor()[1]);
                        break;
                    case KeyEvent.VK_LEFT:
                    	if(ui.getCursor()[0]>0&&(this.element[ui.getCursor()[1]][ui.getCursor()[0]-1].getElement()==' '||this.element[ui.getCursor()[1]][ui.getCursor()[0]-1].getElement()=='+'))
                            ui.setCursor(ui.getCursor()[0]-1, ui.getCursor()[1]);
                    	else if(ui.getCursor()[0]>1&&(this.element[ui.getCursor()[1]][ui.getCursor()[0]-1].getElement()!=' '&&this.element[ui.getCursor()[1]][ui.getCursor()[0]-1].getElement()!='+'))
                            ui.setCursor(ui.getCursor()[0]-2, ui.getCursor()[1]);
                        break;
                    case KeyEvent.VK_DOWN:
                    	if(ui.getCursor()[1]<HEIGHT-1&&(this.element[ui.getCursor()[1]+1][ui.getCursor()[0]].getElement()==' '||this.element[ui.getCursor()[1]+1][ui.getCursor()[0]].getElement()=='+'))
                    		ui.setCursor(ui.getCursor()[0], ui.getCursor()[1]+1);
                    	else if(ui.getCursor()[1]<HEIGHT-2&&(this.element[ui.getCursor()[1]+1][ui.getCursor()[0]].getElement()!=' '&&this.element[ui.getCursor()[1]+1][ui.getCursor()[0]].getElement()!='+'))
                    		ui.setCursor(ui.getCursor()[0], ui.getCursor()[1]+2);
                        break;
                    case KeyEvent.VK_UP:
                    	if(ui.getCursor()[1]>0&&(this.element[ui.getCursor()[1]-1][ui.getCursor()[0]].getElement()==' '||this.element[ui.getCursor()[1]-1][ui.getCursor()[0]].getElement()=='+'))
                            ui.setCursor(ui.getCursor()[0], ui.getCursor()[1]-1);
                    	else if(ui.getCursor()[1]>1&&(this.element[ui.getCursor()[1]-1][ui.getCursor()[0]].getElement()!=' '&&this.element[ui.getCursor()[1]-1][ui.getCursor()[0]].getElement()!='+'))
                            ui.setCursor(ui.getCursor()[0], ui.getCursor()[1]-2);
                        break;
                    case KeyEvent.VK_SPACE:
                    	if((ui.getCursor()[1]%2==0||ui.getCursor()[0]%2==0)) {
                    		if(this.element[ui.getCursor()[1]][ui.getCursor()[0]].getElement()==' '&&this.element[ui.getCursor()[1]][ui.getCursor()[0]].getChained()!=10) {
                    			this.element[ui.getCursor()[1]][ui.getCursor()[0]].setElement('+');
                    			this.plusCount++;
                    			if(ui.getCursor()[1]%2==0) {
                    				this.element[ui.getCursor()[1]][ui.getCursor()[0]+1].setChained(this.element[ui.getCursor()[1]][ui.getCursor()[0]+1].getChained()+1);
                    				this.element[ui.getCursor()[1]][ui.getCursor()[0]-1].setChained(this.element[ui.getCursor()[1]][ui.getCursor()[0]-1].getChained()+1);
                    			}else {
                    				this.element[ui.getCursor()[1]+1][ui.getCursor()[0]].setChained(this.element[ui.getCursor()[1]+1][ui.getCursor()[0]].getChained()+1);
                    				this.element[ui.getCursor()[1]-1][ui.getCursor()[0]].setChained(this.element[ui.getCursor()[1]-1][ui.getCursor()[0]].getChained()+1);
                    			}
                    			
                    		}
                    			
                    		else {
                    			this.element[ui.getCursor()[1]][ui.getCursor()[0]].setElement(' ');
                    			this.plusCount--;
                    			if(ui.getCursor()[1]%2==0) {
                    				this.element[ui.getCursor()[1]][ui.getCursor()[0]+1].setChained(this.element[ui.getCursor()[1]][ui.getCursor()[0]+1].getChained()-1);
                    				this.element[ui.getCursor()[1]][ui.getCursor()[0]-1].setChained(this.element[ui.getCursor()[1]][ui.getCursor()[0]-1].getChained()-1);
                    			}else {
                    				this.element[ui.getCursor()[1]+1][ui.getCursor()[0]].setChained(this.element[ui.getCursor()[1]+1][ui.getCursor()[0]].getChained()-1);
                    				this.element[ui.getCursor()[1]-1][ui.getCursor()[0]].setChained(this.element[ui.getCursor()[1]-1][ui.getCursor()[0]].getChained()-1);
                    			}
                    		}
                    			
                    	}
                        break;
                    case KeyEvent.VK_ENTER:
                    	this.chain = new SingleLinkedList();
                    	int oneChainedCount = 0;
                    	Element oneChained = new Element();
                    	for(int i = 0 ; i < HEIGHT && !gameOver ; i+=2) {
                    		for(int j = 0 ; j < WIDTH && !gameOver ; j+=2) {
                    			if(element[i][j].getChained()>2) {
                    				gameOver = true;
                    			}else if(element[i][j].getChained()==1) {
                    				oneChainedCount++;
                    				oneChained = element[i][j];
                    			}
                    			if(oneChainedCount>2)
                    				gameOver = true;
                    		}
                    	}
                    	if(oneChainedCount!=2)//loop control
                    		gameOver = true;
                    	if(!gameOver) {
                    		chain.add(new Element( oneChained.getHeight(),oneChained.getWidth(),oneChained.getElement()));
                        	element[oneChained.getHeight()][oneChained.getWidth()].setChained(-2);
                    	}
                    	if(!gameOver)
                    	for(int i = 0; i<this.plusCount ; i++) {
                    		boolean foundOne = false;
                    		if(oneChained.getHeight()>0) {
                    			if(element[oneChained.getHeight()-2][oneChained.getWidth()].getChained()>0&&element[oneChained.getHeight()-1][oneChained.getWidth()].getElement()=='+') {
                    				if(Math.abs(Character.getNumericValue(element[oneChained.getHeight()-2][oneChained.getWidth()].getElement())-Character.getNumericValue(oneChained.getElement()))==1) {
                    					element[oneChained.getHeight()-2][oneChained.getWidth()].setChained(-2);
                    					oneChained = element[oneChained.getHeight()-2][oneChained.getWidth()];
                    					chain.add(new Element( oneChained.getHeight(),oneChained.getWidth(),oneChained.getElement()));
                    					foundOne = true;
                    				}else {
                    					gameOver = true;
                    					break;
                    				}
                    			}
                    		}
                    		if(!foundOne&&oneChained.getHeight()<HEIGHT-1) {
                    			if(element[oneChained.getHeight()+2][oneChained.getWidth()].getChained()>0&&element[oneChained.getHeight()+1][oneChained.getWidth()].getElement()=='+') {
                    				if(Math.abs(Character.getNumericValue(element[oneChained.getHeight()+2][oneChained.getWidth()].getElement())-Character.getNumericValue(oneChained.getElement()))==1) {
                    					element[oneChained.getHeight()+2][oneChained.getWidth()].setChained(-2);
                    					oneChained = element[oneChained.getHeight()+2][oneChained.getWidth()];
                    					chain.add(new Element( oneChained.getHeight(),oneChained.getWidth(),oneChained.getElement()));
                    					foundOne = true;
                    				}else {
                    					gameOver = true;
                    					break;
                    				}
                    			}
                    		}
                    		if(!foundOne&&oneChained.getWidth()>0) {
                    			if(element[oneChained.getHeight()][oneChained.getWidth()-2].getChained()>0&&element[oneChained.getHeight()][oneChained.getWidth()-1].getElement()=='+') {
                    				if(Math.abs(Character.getNumericValue(element[oneChained.getHeight()][oneChained.getWidth()-2].getElement())-Character.getNumericValue(oneChained.getElement()))==1) {
                    					element[oneChained.getHeight()][oneChained.getWidth()-2].setChained(-2);
                    					oneChained = element[oneChained.getHeight()][oneChained.getWidth()-2];
                    					chain.add(new Element( oneChained.getHeight(),oneChained.getWidth(),oneChained.getElement()));
                    					foundOne = true;
                    				}else {
                    					gameOver = true;
                    					break;
                    				}
                    			}
                    		}
                    		if(!foundOne&&oneChained.getWidth()<WIDTH-1) {
                    			if(element[oneChained.getHeight()][oneChained.getWidth()+2].getChained()>0&&element[oneChained.getHeight()][oneChained.getWidth()+1].getElement()=='+') {
                    				if(Math.abs(Character.getNumericValue(element[oneChained.getHeight()][oneChained.getWidth()+2].getElement())-Character.getNumericValue(oneChained.getElement()))==1) {
                    					element[oneChained.getHeight()][oneChained.getWidth()+2].setChained(-2);
                    					oneChained = element[oneChained.getHeight()][oneChained.getWidth()+2];
                    					chain.add(new Element( oneChained.getHeight(),oneChained.getWidth(),oneChained.getElement()));
                    					foundOne = true;
                    				}else {
                    					gameOver = true;
                    					break;
                    				}
                    			}
                    		}
                    	}
                    	
                    	int n = chain.size();
                        //controlling the size of chain
                        if (n<4){
                            ui.console.getTextWindow().setCursorPosition(35,17);
                            ui.console.getTextWindow().output("Error In Chain");
                            ui.console.getTextWindow().setCursorPosition(35,18);
                            //chain.display();
                            ui.console.getTextWindow().output("==GAME OVER==");
                            this.gameOver = true;
                            try {
                    			Thread.sleep(2000);
                    		} catch (InterruptedException e) {
                    			// 
                    			e.printStackTrace();
                    		}
                        }
                        //controlling the difference between chain elements
                        if (!this.gameOver){
                        	table.addAndLink(chain);
                            score += Math.pow(n,2);
                            table.tableDisplay(ui.console);
                            round++;
                        }else {
                        	ui.console.getTextWindow().setCursorPosition(35,17);
                            ui.console.getTextWindow().output("Error In Chain");
                            ui.console.getTextWindow().setCursorPosition(35,18);
                            ui.console.getTextWindow().output("==GAME OVER==");
                        }
                        clearElement(element);
                        this.plusCount = 0;
                        break;
                    default:
                        break;
                }
                this.keyPressed=0;
            }
            for(int i = 0 ; i < HEIGHT ; i++) {
                for(int j = 0 ; j < WIDTH ; j++) {
                    ui.displayElement(i, j, element[i][j].getElement());
                }
            }
            try {
    			Thread.sleep(50);
    		} catch (InterruptedException e) {
    			// 
    			e.printStackTrace();
    		}

            if(gameOver) {
            	ui.clear();
            	String name = ""; 
        		do {
        			ui.setCursor(5, 5);
            		name = ui.displayScore();
            		ui.clear();
        		}while(name==" ");
        		highScoreTable(name, score);
        		try {
        			Thread.sleep(2000);
        		} catch (InterruptedException e) {
        			// 
        			e.printStackTrace();
        		}
            	this.keyPressed=0;
                try {
        			Thread.sleep(2000);
        		} catch (InterruptedException e) {
        			// 
        			e.printStackTrace();
        		}
                while(endGame<0) {
            		ui.endGameMessage();
            		this.keyListener=new KeyListener() {
                        public void keyTyped(KeyEvent e) {}
                        public void keyPressed(KeyEvent e) {
                           if(keyPressed==0) {
                        	   keyPressed=1;
                        	   keyCode=e.getKeyCode();
                           }
                        }
                        public void keyReleased(KeyEvent e) {}
                     };
                     ui.console.getTextWindow().addKeyListener(this.keyListener);
                     
                    // Handle player inputs
                    if (this.keyPressed==1) {
                        // Handle player inputs
                        switch (this.keyCode) {
                            case KeyEvent.VK_DOWN:
                            	if(ui.getCursor()[1]<11)
                            		ui.setCursor(ui.getCursor()[0], ui.getCursor()[1]+2);
                                break;
                            case KeyEvent.VK_UP:
                            	if(ui.getCursor()[1]>7)
                                    ui.setCursor(ui.getCursor()[0], ui.getCursor()[1]-2);
                                break;
                            case KeyEvent.VK_ENTER:
                            	switch(ui.getCursor()[1]) {
                            	case 7:
                            		endGame=1;
                            		break;
                            	case 9:
                            		endGame=2;
                            		break;
                            	default:
                            		endGame=-1;
                                    break;
                            	}
                                break;
                            default:
                            	
                                break;
                        }
                        this.keyPressed=0;
                    }
                    try {
            			Thread.sleep(50);
            		} catch (InterruptedException e) {
            			// 
            			e.printStackTrace();
            		}
                    ui.clear();
            	}
            	switch(endGame) {
            	case 1:
            		initGame();
            		break;
            	case 2:
            		showHighScoreTable();
            		try {
            			Thread.sleep(2000);
            		} catch (InterruptedException e) {
            			// 
            			e.printStackTrace();
            		}
            		break;
            	}
            }
            
            
            
        }
    }
	
		
	private void showHighScoreTable() {
		this.highScore = new DoublyLinkedList();
		this.ui.clear();
        // Read high scores from file and add to DLL
        try (BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length < 3) {
                    continue;
                }
                String name = parts[0] + " " + parts[1];
                int score = Integer.parseInt(parts[2]);
                this.highScore.addHighScore(name, score);
            }
        } catch (IOException e) {
            System.out.println("Error reading high score file: " + e.getMessage());
        }
        System.out.println("High Score Table:\n===================");
        this.highScore.display();
	}  
	
	private void highScoreTable(String name2, int score2) {
		this.highScore = new DoublyLinkedList();
		this.ui.clear();
        // Read high scores from file and add to DLL
        try (BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length < 3) {
                    continue;
                }
                String name = parts[0] + " " + parts[1];
                int score = Integer.parseInt(parts[2]);
                this.highScore.addHighScore(name, score);
            }
        } catch (IOException e) {
            System.out.println("Error reading high score file: " + e.getMessage());
        }

        // For example, add a new high score
        this.highScore.addHighScore(name2, score2);

        // Write top 10 high scores back to file
        try (PrintWriter writer = new PrintWriter(new FileWriter("highscore.txt"))) {
        	DoublyLinkedListNode temp = this.highScore.head;
            int count = 0;
            while (temp != null && count < 10) {
                writer.println(temp.name + "\t" + temp.score);
                temp = temp.next;
                count++;
            }
        } catch (IOException e) {
            System.out.println("Error writing high score file: " + e.getMessage());
        }
        System.out.println("High Score Table:\n===================");
        this.highScore.display();
    }
		
	
	private void clearElement(Element[][] elementToClear) {
		for(Element[] i : elementToClear)
			for(Element j : i)
				if(j.getChained()<0) {
					//j.setChained(-1);
					j.setElement('.');
				}else if(j.getElement()=='+') {
					j.setChained(10);
					j.setElement(' ');
				}
	}
	
}
