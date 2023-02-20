package edu.quinnipiac.fourinarow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController


class StartFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        //adding start buttons
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        val startButton = view.findViewById<Button>(R.id.startBut)
        val UserN = view.findViewById<TextView>(R.id.PersonName)

        startButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_startFragment_to_gameFragment)
        }
        return view
    }
}
