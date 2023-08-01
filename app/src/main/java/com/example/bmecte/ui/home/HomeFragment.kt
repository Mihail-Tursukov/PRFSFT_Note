package com.example.bmecte.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bmecte.R
import com.example.bmecte.RecyclerAdapter
import com.example.bmecte.databinding.FragmentHomeBinding
import com.example.bmecte.model.LessonData
import kotlin.math.abs



class HomeFragment : Fragment() {

    private var _binding: com.example.bmecte.databinding.FragmentHomeBinding? = null

    private lateinit var chat_button: View

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        _binding = FragmentHomeBinding.inflate(inflater)

        _binding!!.vpLessons.adapter = RecyclerAdapter(
            listOf(
                LessonData(
                    "1",
                    "Основы Андроида",
                    listOf("View", "Компоненты", "Создание проекта", "Манифест", "Intent")
                ),
                LessonData(
                    "2",
                    "Фрагменты Coroutines",
                    listOf("Binding", "Single Activity", "Custom View", "Coroutines")
                ),
                LessonData(
                    "3",
                    "Третье занятие",
                    listOf("Первый тег", "Второй тег", "Третий тег", "Четвёртый тег", "Пятый тег", "Шестой тег")
                ),
            ),
        )
        _binding!!.vpLessons.offscreenPageLimit = 1
        _binding!!.vpLessons.setPageTransformer { page, position ->
            page.translationX = -50 * position
            page.scaleY = 1 - (0.25f * abs(position))
        }




        chat_button = view.findViewById(R.id.message_chat_button)
        chat_button.setOnClickListener {
//            findNavController().navigate(R.id.navigation_message)
            val navController = findNavController()
            navController.navigate(R.id.navigation_message)
        }
        return view
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}