package com.highground.angkotsmedan.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.highground.angkotsmedan.R
import com.highground.angkotsmedan.model.Angkot
import com.highground.angkotsmedan.viewmodel.AngkotViewModel

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mAngkotViewModel: AngkotViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mAngkotViewModel = ViewModelProvider(this).get(AngkotViewModel::class.java)

        view.findViewById<EditText>(R.id.updateNomorAngkot_et).setText(args.currentAngkot.nomorAngkot)
        view.findViewById<EditText>(R.id.updateRuteAngkot_et).setText(args.currentAngkot.ruteAngkot)
        view.findViewById<EditText>(R.id.updateWarnaAngkot_et).setText(args.currentAngkot.warnaAngkot)

        view.findViewById<Button>(R.id.update_btn).setOnClickListener {
            updateItem()
        }

        view.findViewById<FloatingActionButton>(R.id.btn_delete).setOnClickListener {
            deleteAngkot()
        }

        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem(){
        val addNomorngkot = view?.findViewById<EditText>(R.id.updateNomorAngkot_et)
        val addRuteAngkot = view?.findViewById<EditText>(R.id.updateRuteAngkot_et)
        val addWarnaAngkot = view?.findViewById<EditText>(R.id.updateWarnaAngkot_et)

        val nomorAngkot = addNomorngkot!!.text.toString()
        val ruteAngkot = addRuteAngkot!!.text.toString()
        val warnaAngkot = addWarnaAngkot!!.text.toString()

        if(inputCheck(nomorAngkot, ruteAngkot, warnaAngkot)){
            val updatedAngkot = Angkot(args.currentAngkot.id, nomorAngkot, ruteAngkot, warnaAngkot)
            mAngkotViewModel.updateAngkot(updatedAngkot)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all field!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(nomorAngkot: String, ruteAngkot: String, warnaAngkot: String): Boolean{
        return !(TextUtils.isEmpty(nomorAngkot) && TextUtils.isEmpty(ruteAngkot) && TextUtils.isEmpty(warnaAngkot))
    }

    private fun deleteAngkot() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){ _,  _ ->
            mAngkotViewModel.deleteAngkot(args.currentAngkot)
            Toast.makeText(requireContext(), "Successfully removed: ${args.currentAngkot.nomorAngkot} - ${args.currentAngkot.warnaAngkot}", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){_,  _ ->}
        builder.setTitle("Delete ${args.currentAngkot.nomorAngkot} - ${args.currentAngkot.warnaAngkot}")
        builder.setMessage("Are you sure want to delete ${args.currentAngkot.nomorAngkot} - ${args.currentAngkot.warnaAngkot}")
        builder.create().show()
    }
}