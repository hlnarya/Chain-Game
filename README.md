# Chain-Game

The aim of the project is to develop a number game. 

 
General Information

The game is played in a board with 10*16 area of numbers. Game elements are numbers (1-4) and plus signs. The aim of the game is reaching the highest score by constructing number chains.


Game Elements

Board
•	Consist of 10*16 area of numbers 

Numbers
•	Number set: 1, 2, 3, 4 

+
•	Player constructs chains by inserting + into the suitable places.  
o	Cursor keys: To move cursor on the board
o	Space: Insert/remove +
o	Enter: End of the round and calculate the chain
o	E: End of the game

Chain
•	A chain is number squares joined with plus signs in 4 directions.
•	Difference must be 1 between numbers of neighbor squares in the chain.  

Table
•	In each round, constructed chains are accumulated in the table.


Game Initialization

Number area of the board (10*16) is filled with 1, 2, 3 or 4 numbers with equal probability. Player can set the random number seed.


Game Playing Information

In each round;
•	Player constructs a single chain by inserting + into the suitable places.
•	Chain rules:
o	There must be only one chain in each round. Chain with more than one part, broken chains, wrong positioned plus signs are prohibited.
o	Difference between neighbor squares in the chain must be 1 (+1 or -1). 
o	The number of squares in the chain must be at least 4.
o	The score of the chain is n2 (n: The number of elements in the chain) 
•	When the chain is constructed, the player presses the enter key.
o	Then the chain is checked. 
	If the chain has errors or insufficient elements, game is over with the current score of the player.
	If the chain is correct: 
•	The chain is added to the table.
•	The chain disappears from the board.
•	The score of the chain is calculated and added to the player's score.
•	Next round starts.


![image](https://github.com/hlnarya/Chain-Game/assets/142156676/90a3127e-e2aa-441a-b117-3dd0623da776)

![image](https://github.com/hlnarya/Chain-Game/assets/142156676/b717315d-3478-4598-8bec-3d2a250acc84)

![image](https://github.com/hlnarya/Chain-Game/assets/142156676/64bb41bd-8e80-41eb-a6cc-88aa0a41408e)


![image](https://github.com/hlnarya/Chain-Game/assets/142156676/872880fb-6c48-4e96-82f9-75747d7711ac)
