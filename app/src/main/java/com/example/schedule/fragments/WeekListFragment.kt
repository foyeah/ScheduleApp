package com.example.schedule.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.DataStorage
import com.example.schedule.R
import com.example.schedule.adapters.DaysAdapter
import com.example.schedule.databinding.FragmentWeekListBinding
import com.example.schedule.enums.WeekEnum
import com.example.schedule.models.Week

class WeekListFragment : Fragment() {
    private var binding: FragmentWeekListBinding? = null
    private var adapter: DaysAdapter = DaysAdapter()
    private var number: WeekEnum = WeekEnum.FIRST
    private var storage: DataStorage = DataStorage()
    private var week: Week = storage.getWeek(number)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            this ?: return
            this.weekNumView.text = if (number == WeekEnum.FIRST) "Первая неделя" else "Вторая неделя"
            this.groupView.text = "ПрИ-301"
            this.weekMenu.setOnMenuItemClickListener {
                changeWeek(it.itemId)
                true
            }
        }
        with(binding?.mainView) {
            this ?: return
            layoutManager = LinearLayoutManager(context)
            adapter = this@WeekListFragment.adapter
            addItemDecoration(createItemDecorator())
        }
        adapter.submitList(week.days)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeekListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun changeWeek(@IdRes id: Int){
        when(id) {
            R.id.first_week ->
                number = WeekEnum.FIRST
            R.id.second_week ->
                number = WeekEnum.SECOND
        }
        refresh()
    }

    private fun createItemDecorator() =
        DividerItemDecoration(requireContext(), RecyclerView.VERTICAL).apply {
            ContextCompat.getDrawable(requireContext(), R.drawable.day_item_decorator)
                ?.let { this@apply.setDrawable(it) }
        }

    private fun refresh(){
        week = storage.getWeek(number)
        with(binding) {
            this ?: return
            this.weekNumView.text = if (number == WeekEnum.FIRST) "Первая неделя" else "Вторая неделя"
            adapter.submitList(week.days)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): WeekListFragment = WeekListFragment()
    }
}