package com.highground.angkotsmedan.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.highground.angkotsmedan.R
import com.highground.angkotsmedan.model.Angkot
import com.highground.angkotsmedan.viewmodel.AngkotViewModel

class AddFragment : Fragment() {

    private lateinit var mAngkotViewModel: AngkotViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mAngkotViewModel = ViewModelProvider(this).get(AngkotViewModel::class.java)

        view.findViewById<Button>(R.id.add_btn).setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }


    private fun insertDataToDatabase() {
        val addNomorngkot = view?.findViewById<EditText>(R.id.addNomorAngkot_et)
        val addRuteAngkot = view?.findViewById<EditText>(R.id.addRuteAngkot_et)
        val addWarnaAngkot = view?.findViewById<EditText>(R.id.addWarnaAngkot_et)

        val nomorAngkot = addNomorngkot!!.text.toString()
        val ruteAngkot = addRuteAngkot!!.text.toString()
        val warnaAngkot = addWarnaAngkot!!.text.toString()

        if(inputCheck(nomorAngkot, ruteAngkot, warnaAngkot)){
            // Create User Object
            val angkot = Angkot(0, nomorAngkot, ruteAngkot, warnaAngkot)
            // Add Data to Database
            mAngkotViewModel.addAngkot(angkot)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(nomorAngkot: String, ruteAngkot: String, warnaAngkot: String): Boolean{
        return !(TextUtils.isEmpty(nomorAngkot) && TextUtils.isEmpty(ruteAngkot) && TextUtils.isEmpty(warnaAngkot))
    }

}