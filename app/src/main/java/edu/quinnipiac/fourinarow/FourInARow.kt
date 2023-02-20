

/**
 * TicTacToe class implements the interface IGame.kt
 * @author Aaryan Kapoor
 * @date 2/2/2023
 */
class FourInARow
/**
 * clear board and set current player
 */
    : IGame {
    // game board in 2D array initialized to zeros
    private val board = Array(GameConstants.ROWS) { IntArray(GameConstants.COLS){0} }

    override fun clearBoard() {
        for(i in 0 until GameConstants.ROWS){
            for(j in 0 until GameConstants.COLS){
                board[i][j] = GameConstants.EMPTY
            }
        }
        // TODO Auto-generated method stub
    }

    override fun setMove(player: Int, location: Int) {
       if(player == 1){
           val row = location/GameConstants.ROWS
           val column = location%GameConstants.COLS
           board[row][column] = 1
       }
        if(player == 2){
            val row = location/GameConstants.ROWS
            val column = location%GameConstants.COLS
            board[row][column] = 2
        }
        // TODO Auto-generated method stub
    }

    override val computerMove: Int
        get() {
            val total: Int = GameConstants.ROWS * GameConstants.COLS
            var randBool : Boolean = false
            while(!randBool){
                val random: Int = (0 until total).random()
                val row = random / GameConstants.ROWS
                val column = random % GameConstants.COLS
                if(board[row][column] == GameConstants.EMPTY){
                    return random
                }
            }
            return 404
        }
    // TODO Auto-generated method stub

    override fun checkForWinner(): Int {
        // Finds horizontal winners
        for(p in 0 until GameConstants.ROWS){
            for(x in 0 until GameConstants.COLS-3){
                if(board[p][x] != 0 && board[p][x] == board[p][x+1] && board[p][x] == board[p][x+2] && board[p][x] == board[p][x+3]){
                    if(board[p][x] == 1){
                        return GameConstants.BLUE_WON
                    } else {
                        return GameConstants.RED_WON
                    }
                }
            }
        }

        // Checks for vertical winners
        for (s in 0 until GameConstants.ROWS - 3){
            for(t in 0 until GameConstants.COLS){
                if(board[s][t] != 0 && board[s][t] == board[s + 1][t] && board[s][t] == board[s + 2][t] && board[s][t] == board[s + 3][t]){
                    if(board[s][t] == 1){
                        return GameConstants.BLUE_WON
                    } else {
                        return GameConstants.RED_WON
                    }
                }
            }
        }
        //Checks for diagonal pointing to the right
        for( l in 0 until GameConstants.ROWS-3){
            for (m in 0 until GameConstants.COLS-3){
                if(board[l][m] != 0 && board[l][m] == board[l + 1][m + 1] && board[l][m] == board[l + 2][m + 2] && board[l][m] == board[l + 3][m + 3]){
                    if(board[l][m] == 1){
                        return GameConstants.BLUE_WON
                    } else {
                        return GameConstants.RED_WON
                    }
                }
            }
        }
        //Checks for diagonal pointing to the left
        for(s in 0 until GameConstants.ROWS-3){
            for(t in 3 until GameConstants.COLS){
                if(board[s][t] != 0 && board[s][t] == board[s + 1][t - 1] && board[s][t] == board[s + 2][t - 2] && board[s][t] == board[s + 3][t - 3]){
                    if(board[s][t] == 1){
                        return GameConstants.BLUE_WON
                    } else {
                        return GameConstants.RED_WON
                    }
                }
            }
        }
        //Finally checks for ties
        var tieCheck : Boolean = true
        for(i in 0 until GameConstants.ROWS){
            for(j in 0 until GameConstants.COLS){
                if(board[i][j] == 0){
                    tieCheck = false
                    break
                }
            }
        }
        if(tieCheck == true){
            return GameConstants.TIE
        }

        return 404
    }

    /**
     * Print the game board
     */
    fun printBoard() {
        for (row in 0 until GameConstants.ROWS) {
            for (col in 0 until GameConstants.COLS) {
                printCell(board[row][col]) // print each of the cells

                if (col != GameConstants.COLS - 1) {
                    print("║") // print vertical partition
                }

            }
            println()

            if (row != GameConstants.ROWS - 1) {
                //println("-----------------------") // print horizontal partition
                println("╔==╦===╦===╦===╦===╦===╗")
            }
        }
        println()
        println()
    }

    /**
     * Print a cell with the specified "content"
     * @param content either BLUE, RED or EMPTY
     */
    fun printCell(content: Int) {
        when (content) {
            GameConstants.EMPTY -> print("   ")
            GameConstants.BLUE -> print(" H ")
            GameConstants.RED -> print(" C ")
        }
    }
}

