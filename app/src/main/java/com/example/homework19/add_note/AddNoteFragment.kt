package com.example.homework19.add_note

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.example.homework19.R
import com.example.homework19.databinding.FragmentAddNoteBinding
import java.io.File

class AddNoteFragment : Fragment() {
    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var tempImageUri: Uri
    private val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){ galleryUri->
        binding.imageButtonLoadPhoto.setImageURI(galleryUri)
    }
    private val photoLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()){
        binding.imageButtonLoadPhoto.setImageURI(tempImageUri)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        tempImageUri = initTempUri()
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backFragment()
        clickButtonLoadPhoto()
        clickButtonDoPhoto()

    }
    private fun backFragment(){
        binding.toolbarAddNote.setNavigationOnClickListener{
            parentFragmentManager.popBackStack()
        }
    }
    private fun clickButtonLoadPhoto(){
        binding.imageButtonLoadPhoto.setOnClickListener{
            galleryLauncher.launch("image/*")
        }
    }
    private fun clickButtonDoPhoto() {
        binding.floatingActionButtonDoPhoto.setOnClickListener {
            photoLauncher.launch(tempImageUri)
        }
    }
    private fun initTempUri(): Uri{
        val tempImageDir = File(
            requireContext().filesDir,
            getString(R.string.temp_images_dir)
        )
        tempImageDir.mkdir()

        val tempImage = File(
            tempImageDir,
            getString(R.string.temp_image)
        )
        return FileProvider.getUriForFile(
            requireContext(),
            getString(R.string.authority),
            tempImage
        )
    }
}