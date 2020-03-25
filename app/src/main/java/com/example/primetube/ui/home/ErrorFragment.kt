package com.example.primetube.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.primetube.R
import com.example.primetube.ui.live.LiveFragment
import kotlinx.android.synthetic.main.fragment_error.*

/**
 * A simple [Fragment] subclass.
 */
class ErrorFragment : Fragment() {

    companion object{
        var HomeFragmentError = "HOMEFRAGMENTERRORSRC"
        var LiveFragmentError = "LIVEFRAGMENTERRORSRC"
        var LiveFragment = "LIVEFRAGMENTERRORSRC"
        var SignupFragment = " SIGNUPFRAGMENT"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_error, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var bundle = arguments
        var errormessaage  = bundle?.getString("message")
        var errorSrc = bundle?.getString("src")
        error_tv.text = errormessaage


        error_btn.setOnClickListener{view ->
            if(errorSrc == HomeFragmentError){
                findNavController().navigate(R.id.navigation_home)
            }
        }
    }

}
