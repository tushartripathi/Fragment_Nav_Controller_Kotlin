package com.example.navicontroller

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation

class firstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_first, container, false)

        var textVIew:TextView = view.findViewById(R.id.textView)
        textVIew.setOnClickListener()
        {
            val action = firstFragmentDirections.actionFirstFragmentToSecondFragment(66)
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }

}