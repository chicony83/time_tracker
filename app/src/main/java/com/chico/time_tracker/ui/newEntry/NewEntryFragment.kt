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
import com.chico.time_tracker.utils.parseDateToMillisDdMmYyyy
import com.chico.time_tracker.utils.parseTimeToMillisHhMm

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

//        setDefaultValuesWhenStartToUI()

        with(newEntryViewModel){
            moneyPerHour.observe(viewLifecycleOwner){
                binding.moneyPerHourEditText.setText(it.toString())
            }
            date.observe(viewLifecycleOwner) {
                binding.workDateTextView.text = it
            }
            startTime.observe(viewLifecycleOwner){
                binding.startTimeTextView.text = it
            }
            endTime.observe(viewLifecycleOwner){
                binding.endTimeTextView.text = it
            }
            address.observe(viewLifecycleOwner){
                binding.addressEditText.setText(it.toString())
            }
            description.observe(viewLifecycleOwner){
                binding.description.setText(it.toString())
            }
        }

        binding.submitButton.setOnClickListener {

            MessageLog.log("press submit button")

            val workingTime = getWorkingTime()

            val isWorkingTimeChecked = newEntryViewModel.chekWorkingTime(workingTime)

            if (isWorkingTimeChecked) newEntryViewModel.saveWorkingTime(workingTime)

        }
    }

    private fun setDefaultValuesWhenStartToUI() {
        binding.moneyPerDayTextView.text = "25"
        binding.workDateTextView.text = "16.05.2022"
        binding.startTimeTextView.text = "6.00"
        binding.endTimeTextView.text = "18.00"
        binding.workHoursInDayTextView.text = "12"
        binding.moneyPerDayTextView.text = "300"
        //        binding.moneyPerDayTextView.setText(
//            binding.moneyPerHourEditText.text.toString().toInt() *
//                    binding.workHoursInDayTextView.text.toString().toInt()
//        ).toString()
    }

    private fun getWorkingTime(): WorkingTime {
        return WorkingTime(
            date = binding.workDateTextView.text.toString().parseDateToMillisDdMmYyyy(),
            startTime = binding.startTimeTextView.text.toString().parseTimeToMillisHhMm().toInt(),
            endTime = binding.endTimeTextView.text.toString().parseTimeToMillisHhMm().toInt(),
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