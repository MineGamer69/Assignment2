package edu.quinnipiac.fourinarow

import FourInARow
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.navigation.NavController
import androidx.navigation.Navigation


class GameFragment : Fragment(),View.OnClickListener {

    val btn_Array = arrayOf(
        R.id.button1,
        R.id.button2,
        R.id.button3,
        R.id.button4,
        R.id.button5,
        R.id.button6,
        R.id.button7,
        R.id.button8,
        R.id.button9,
        R.id.button10,
        R.id.button11,
        R.id.button12,
        R.id.button13,
        R.id.button14,
        R.id.button15,
        R.id.button16,
        R.id.button17,
        R.id.button18,
        R.id.button19,
        R.id.button20,
        R.id.button21,
        R.id.button22,
        R.id.button23,
        R.id.button24,
        R.id.button25,
        R.id.button26,
        R.id.button27,
        R.id.button28,
        R.id.button29,
        R.id.button30,
        R.id.button31,
        R.id.button32,
        R.id.button33,
        R.id.button34,
        R.id.button35,
        R.id.button36
    )

    val listner = arrayListOf<Button>()
    lateinit var uName: String
    lateinit var NavCtrl: NavController
    var FourInARow = FourInARow()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val valBund = arguments
        if(valBund == null){
            return
        }
        uName = GameFragmentArgs.fromBundle(valBund).userName.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Essentially setting up the inflator for the buttons, and sets up the on click listner and final view
        val view = inflater.inflate(R.layout.fragment_game, container, false)

        for(i in 0 until btn_Array.size){
            listner.add(view.findViewById<Button>(btn_Array[i]))
        }
        for(i in 0 until listner.size){
            listner.get(i).background = ContextCompat.getDrawable(requireContext(), R.drawable.cleanboard)
            listner.get(i).setOnClickListener(this)

        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Save instance module and setting up controllers and finding the nav view
        super.onViewCreated(view, savedInstanceState)
        NavCtrl = Navigation.findNavController(view)
        view.findViewById<TextView>(R.id.userID).text = uName
    }

    override fun onClick(p0: View?) {
        //Sets up the reset button to clear the board
        val onResetDone: Button? = view?.findViewById(R.id.reset)
        view?.findViewById<Button>(R.id.reset)
        onResetDone?.setOnClickListener{
            FourInARow.clearBoard()
            for(i in 0 until listner.size){
                listner.get(i).background = ContextCompat.getDrawable(requireContext(), R.drawable.cleanboard)
                //listner.get(i).setBackgroundColor(Color.rgb(99, 5, 220))
            }
        }
        //Sets up player move via button clicks

        for(i in 0 until listner.size){
            val onClickDone: Button = view?.findViewById(btn_Array[i])!!
            if(onClickDone == p0){
                listner.get(i).background = ContextCompat.getDrawable(requireContext(), R.drawable.human)
                //onClickDone.setBackgroundColor(Color.RED)
                FourInARow.setMove(1, i)
            }
        }
        //Setups up the computer move

        val comMove = FourInARow.computerMove
        FourInARow.setMove(2, comMove)
        listner.get(comMove).background = ContextCompat.getDrawable(requireContext(), R.drawable.computer)
        //listner.get(comMove).setBackgroundColor(Color.BLUE)
        //Check for winner move every time a player or computer runs a move it checks for winner
        FourInARow.checkForWinner()
        if(FourInARow.checkForWinner() == 3){
            Toast.makeText(context,uName + " has Won!", Toast.LENGTH_SHORT).show()
        }
        if(FourInARow.checkForWinner() == 2){
            Toast.makeText(context, "Computer has Won!", Toast.LENGTH_SHORT).show()
        }

    }


}

