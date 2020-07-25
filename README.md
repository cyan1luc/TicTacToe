# TicTacToe
Personal Practice Project.

Each class contains logic specific to individual components of the project. The main class is composed of all the other components which combines all the logic so it can work together and provide the full TicTacToe game experience.

This project uses arrays to create the tictactoe board and it takes player input to change change the board space to their move (X or O). It uses a loop to count how many turns have passed, once it goes past the 9th turn, the game will end with a draw if there is no winner. To check for a winner, a hashset was used to check what move is on the row, column, and diagonals of the board. If there is a consecutive match of the same move, the players name is printed out and states they win.
