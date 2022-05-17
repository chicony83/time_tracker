package com.chico.time_tracker.ui.newEntry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.chico.time_tracker.databinding.FragmentNewEntryBinding
import com.chico.time_tracker.db.entity.WorkingTime
import com.chico.time_tracker.utils.MessageLog
import com.chico.time_tracker.utils.parseTimeToMillis

class NewEntryFragment : Fragment() {

    private lateinit var newEntryViewModel: NewEntryViewModel

    private var _binding: FragmentNewEntryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        newEntryViewModel = ViewModelProvider(this)[NewEntryViewModel::class.java]

        _binding = FragmentNewEntryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.submitButton.setOnClickListener {

            MessageLog.log("press submit button")

            val workingTime = getWorkingTime()

            val isWorkingTimeChecked = newEntryViewModel.chekWorkingTime(workingTime)

            if (isWorkingTimeChecked) newEntryViewModel.saveWorkingTime(workingTime)

        }
    }

    private fun getWorkingTime(): WorkingTime {
        return WorkingTime(
            date = binding.workDateTextView.text.toString().parseTimeToMillis(),
            startTime = binding.startTimeTextView.text.toString().toInt(),
            endTime = binding.endTimeTextView.text.toString().toInt(),
            workHoursInDay = binding.workHoursInDayTextView.text.toString().toInt(),
            moneyPerHour = binding.moneyPerHourEditText.text.toString().toInt(),
            moneyPerDay = binding.moneyPerDayTextView.text.toString().toInt(),
            address = null,
            description = null,
            coordinates = null
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}