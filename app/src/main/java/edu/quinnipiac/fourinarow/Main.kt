//Initializing board
val FIR_board = FourInARow()
/** The entry main method (the program starts here)  */
fun main() {
    //Displays current game state (and takes user input)
    var currentState: Int = GameConstants.PLAYING
    val userInput = ""
    print("Enter your name: ")
    val userName = readLine()
    //Game Loop
    //Setting up a try loop as if the index is out of bounds it will throw an error that can be shown to the user
    try {
        do {
            FIR_board.printBoard()
            print("Enter your move: ")
            val userInput = readLine()
            if(userInput == "q"){
                FIR_board.clearBoard()
                FIR_board.printBoard()
                println("Quitting Game...")
                break
            }
            var intInput: Int = Integer.parseInt(userInput)
            //Sets player move and constantly checks for player win
            FIR_board.setMove(1, intInput)
            if (FIR_board.checkForWinner() == 3) {
                FIR_board.printBoard()
                println(userName + " WON!")

                currentState = GameConstants.BLUE_WON
                break
            }
            //Sets Computer move and constantly checks for a winner
            FIR_board.setMove(2, FIR_board.computerMove)
            if(FIR_board.checkForWinner() == 2){
                FIR_board.printBoard()
                println("AI WON")
                currentState = GameConstants.RED_WON
            }
        }while (currentState == GameConstants.PLAYING && userInput != "q")
    } catch (e: ArrayIndexOutOfBoundsException){
        //Catches the exception to number being out of bounds.
        println("Incorrect number Please restart and enter between 0-35 or 'q' to quit")
    }
}
 