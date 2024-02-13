public class Main {
    public static void main(String[] args) {
    	
        try {
        	ChainGame chainGame = new ChainGame();
        	chainGame.initGame();
         
        } catch (Exception exception) 
        {
            System.err.printf("Error: %s", exception.getMessage());

        }
    }
}
