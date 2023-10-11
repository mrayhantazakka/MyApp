package com.example.myapp.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapp.databinding.FragmentProfilBinding


class ProfilFragment : Fragment() {
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textViewNim: TextView = binding.textViewNim
        val textViewNama: TextView = binding.textViewNama
        val textViewAlamat: TextView = binding.textViewAlamat
        val textViewKodePos: TextView = binding.textViewKodePos
        val textViewNoTelp: TextView = binding.textViewNoTelp
        val textViewProgramStudi: TextView = binding.textViewProgramStudi
        val textViewSemester: TextView = binding.textViewNoSemester
        val textViewGolongan: TextView = binding.textViewNoGolongan

        // Mengatur data-data profil secara langsung
        textViewNim.text = "Nim: E41221547"
        textViewNama.text = "Nama: Muhammad Rayhan Tazakka"
        textViewAlamat.text = "Alamat: Tanggul"
        textViewKodePos.text = "Kode Pos: 68155"
        textViewNoTelp.text = "NoTelp/HP: 085334595068"
        textViewProgramStudi.text = "Program Studi: D4-Teknik Informatika"
        textViewSemester.text = "Semester Tempuh: 3"
        textViewGolongan.text = "Golongan: C"

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
