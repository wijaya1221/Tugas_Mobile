package com.highground.angkotsmedan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.highground.angkotsmedan.model.Angkot
import com.highground.angkotsmedan.viewmodel.AngkotViewModel

class HomeFragment : Fragment() {

    private lateinit var mAngkotViewModel: AngkotViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        mAngkotViewModel = ViewModelProvider(this).get(AngkotViewModel::class.java)

        val angkot1 = Angkot(1, "01", "Simp. Permina – Tanjung Morawa – Simp. Kayu Besar – Lubuk Pakam", "Kuning")
        mAngkotViewModel.addAngkot(angkot1)

        val angkot2 = Angkot(2, "02", "Jl. Karya – Bundaran Sekip – Petisah – Plaza Medan Fair – Jl. Iskandar Muda –\n" +
                "Simp. Brimob – Simp. Kampus – P. Bulan – Simp. Pos – Titi Kuning – Simp. Limun – Jl.\n" +
                "Sisingamangaraja – Jl. Halat – Jl. AR Hakim – Jl. Denai – Perumnas Mandala", "Kuning")
        mAngkotViewModel.addAngkot(angkot2)

        val angkot3 = Angkot(3, "03", "POLDASU – Amplas – Jl. Sisingamangaraja – Garuda Plaza Hotel – (?) – Sambu", "Kuning")
        mAngkotViewModel.addAngkot(angkot3)

        val angkot4 = Angkot(4, "A03", "UNIMED – Jl. Pancing – Aksara – Pasar V Desa Martoba/ Batas Kota", "Kuning")
        mAngkotViewModel.addAngkot(angkot4)

        val angkot5 = Angkot(5, "N03", "Tuntungan – Lau Bakeri – Tanjung Anom – Pajak Melati – Simp. Pemda – Simp. Pos –\n" +
                "Titi Kuning – Amplas – Tanjung Morawa – Lubuk Pakam", "Kuning")
        mAngkotViewModel.addAngkot(angkot5)

        val angkot6 = Angkot(6, "05", "Jalan SM.Raja – Mariendal – PP", "Kuning")
        mAngkotViewModel.addAngkot(angkot6)

        val angkot7 = Angkot(7, "06", "Pinang Baris – Pajak Melati – Simp. Pemda – Tanjung Sari – TASBI Pintu 1 – Jl. Dr. Mansyur – USU – Simp. Kampus – Simp. Brimob – Jl. S. Parman – Jl. Monginsidi – Jl.Ir. H. Juanda – Jl. Sisingamangaraja – Amplas", "Kuning")
        mAngkotViewModel.addAngkot(angkot7)

        val angkot8 = Angkot(8, "07", "Jalan T. Amplas – Teladan-Letda Sujono / Batas Kota – PP07\n" +
                "Amplas – Jl. Sisingamangaraja – Aksara – Jl. Pancing – Tembung", "Kuning")
        mAngkotViewModel.addAngkot(angkot8)

        val angkot9 = Angkot(9, "08", "Rute: Jl. Palang Merah – B Katamso – Istana Maimun – Pancing-Titi Kuning – Deli Tua", "Kuning")
        mAngkotViewModel.addAngkot(angkot9)

        val angkot10 = Angkot(10, "10", "Rute: Perumnas Simalingkar – Simp. Pos – Padang Bulan – Simp. Kampus – Simp. Brimob –\n" +
                "Pringgan – Jl. Hayam Wuruk – Jl. S. Parman – Jl. Jend. Sudirman – Taman Beringin –\n" +
                "Kantor Gubernur – Sun Plaza – Simp. Selecta – Jl. Palang Merah – Jl. Sutomo – Sambu –\n" +
                "Aksara", "Kuning")
        mAngkotViewModel.addAngkot(angkot10)
        return view
    }
}