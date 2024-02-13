package com.example.homework19.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework19.R
import com.example.homework19.add_note.AddNoteFragment
import com.example.homework19.databinding.FragmentListNotesBinding

class ListNotesFragment : Fragment() {
    private var _binding: FragmentListNotesBinding?= null
    private val binding get() = _binding!!

    private lateinit var adapter: ListNotesAdapter
    private lateinit var viewModel: ListNotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListNotesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, ListNotesFactory(ListNotesRepository()))[ListNotesViewModel::class.java]
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchListNotes()
        initAdapter()
        clickButtonAddNote()
        initObserve()
    }
    private fun initAdapter(){
        adapter = ListNotesAdapter()
        binding.recyclerViewTodoList.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTodoList.adapter = adapter
        initObserve()
    }
    private fun clickButtonAddNote(){
        binding.floatingActionButtonAddNote.setOnClickListener{
            loadFragment()
        }
    }
    private fun loadFragment(){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, AddNoteFragment())
            .addToBackStack("listNotes")
            .commit()
    }
    private fun initObserve(){
        viewModel.listNotes.observe(viewLifecycleOwner){listNotes->
            adapter.submitList(listNotes)
        }
    }
}