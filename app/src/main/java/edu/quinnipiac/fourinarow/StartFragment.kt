package edu.quinnipiac.fourinarow

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController


class StartFragment : Fragment(), View.OnClickListener{
    //initializes the start screen
    lateinit var NavCtrl: NavController

    //Sets up the create view and finishes creating the onCreateView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //adding start buttons
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    //Sets up the nav controller for the start main menu

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavCtrl = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.startBut).setOnClickListener(this)
    }
    //Navigates from start screen to next screen when button is clicked
    override fun onClick(v: View?){
        val usName: EditText = requireView().findViewById(R.id.PersonName)
        if(!TextUtils.isEmpty(usName.text.toString())){
            val uPlayer = usName.text.toString()
            val doAction = StartFragmentDirections.actionStartFragmentToGameFragment(uPlayer)
            v?.findNavController()?.navigate(doAction)
        }

    }
}
