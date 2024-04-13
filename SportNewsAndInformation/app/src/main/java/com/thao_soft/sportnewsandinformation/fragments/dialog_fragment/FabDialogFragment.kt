package com.thao_soft.sportnewsandinformation.fragments.dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.thao_soft.sportnewsandinformation.MainActivity
import com.thao_soft.sportnewsandinformation.R
import com.thao_soft.sportnewsandinformation.fragments.athletes_fragment.placeholder.AthleteContent
import com.thao_soft.sportnewsandinformation.fragments.events_fragment.placeholder.EventContent
import com.thao_soft.sportnewsandinformation.fragments.historical_archive_fragment.placeholder.ArchiveContent
import com.thao_soft.sportnewsandinformation.fragments.news_fragment.placeholder.NewsContent
import com.thao_soft.sportnewsandinformation.fragments.sport_fragment.placeholder.SportContent
import com.thao_soft.sportnewsandinformation.utils.DateUtils


class FabDialogFragment : DialogFragment() {
    private var type: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = arguments?.getInt("type")
    }

    override fun onStart() {
        super.onStart()
        if (dialog != null) {
            dialog!!.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = when (type) {
            0 -> {
                inflater.inflate(R.layout.fragment_sport_dialog, container, false)
            }

            1 -> {
                inflater.inflate(R.layout.fragment_news_dialog, container, false)
            }

            2 -> {
                inflater.inflate(R.layout.fragment_athlete_dialog, container, false)
            }

            3 -> {
                inflater.inflate(R.layout.fragment_events_dialog, container, false)
            }

            4 -> {
                inflater.inflate(R.layout.fragment_archive_dialog, container, false)
            }

            else -> {
                super.onCreateView(inflater, container, savedInstanceState)
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (type) {
            0 -> {
                val spinner = view.findViewById<Spinner>(R.id.sportTypeSpinner)
                val arrayAdapter = ArrayAdapter.createFromResource(
                    requireContext(),
                    R.array.sport_types_array,
                    android.R.layout.simple_spinner_item
                )

                spinner.adapter = arrayAdapter

                view.findViewById<Button>(R.id.addSportItem).setOnClickListener {
                    val currentType = spinner.selectedItem.toString()
                    val name =
                        view.findViewById<TextInputEditText>(R.id.sportNameTxtField).text.toString()
                    val instruction =
                        view.findViewById<TextInputEditText>(R.id.instructionsTxtField).text.toString()

                    SportContent.addItem(currentType, name, instruction)
                    val mainActivity: MainActivity = requireActivity() as MainActivity
                    mainActivity.refreshFragmentList()
                    dismiss()
                }
            }

            1 -> {
                view.findViewById<Button>(R.id.addNewsItem).setOnClickListener {
                    val url = view.findViewById<TextInputEditText>(R.id.urlTxtField).text.toString()
                    val title =
                        view.findViewById<TextInputEditText>(R.id.titleTxtField).text.toString()
                    val description =
                        view.findViewById<TextInputEditText>(R.id.descriptionTxtField).text.toString()


                    NewsContent.addItem(url, title, description)
                    val mainActivity: MainActivity = requireActivity() as MainActivity
                    mainActivity.refreshFragmentList()
                    dismiss()
                }
            }

            2 -> {
                view.findViewById<Button>(R.id.addAthleteItem).setOnClickListener {
                    val athleteName =
                        "Name: " + view.findViewById<TextInputEditText>(R.id.athleteNameTxtField).text.toString()

                    val sportName =
                        "Sport: " + view.findViewById<TextInputEditText>(R.id.sportNameTxtField).text.toString()
                    val country =
                        "Country: " + view.findViewById<TextInputEditText>(R.id.countryTxtField).text.toString()
                    val bestPerformance =
                        "Personal Best: " + view.findViewById<TextInputEditText>(R.id.performanceTxtField).text.toString()
                    val medals =
                        "Medals: " + view.findViewById<TextInputEditText>(R.id.medalsTxtField).text.toString()
                    val facts =
                        "Facts: " + view.findViewById<TextInputEditText>(R.id.factsTxtField).text.toString()

                    AthleteContent.addItem(
                        athleteName,
                        sportName,
                        country,
                        bestPerformance,
                        medals,
                        facts
                    )
                    val mainActivity: MainActivity = requireActivity() as MainActivity
                    mainActivity.refreshFragmentList()
                    dismiss()
                }
            }

            3 -> {
                val datePicker =
                    MaterialDatePicker.Builder.datePicker()
                        .setTitleText("Select date")
                        .build()

                var dateTxt = "N/A"
                datePicker.addOnPositiveButtonClickListener {

                    if (datePicker.selection != null) {
                        dateTxt = DateUtils.getDate(datePicker.selection!!, "MM/dd/yyyy")
                    }

                    view.findViewById<TextView>(R.id.dateTxt).text = dateTxt
                }

                view.findViewById<Button>(R.id.selectDateBtn).setOnClickListener {
                    datePicker.show(parentFragmentManager, "DatePicker")
                }

                view.findViewById<Button>(R.id.addEventItem).setOnClickListener {
                    val eventName =
                        view.findViewById<TextInputEditText>(R.id.nameTxtField).text.toString()
                    val description =
                        view.findViewById<TextInputEditText>(R.id.descriptionTxtField).text.toString()

                    EventContent.addItem(eventName, description, dateTxt)

                    val mainActivity: MainActivity = requireActivity() as MainActivity
                    mainActivity.refreshFragmentList()
                    dismiss()
                }
            }

            4 -> {
                view.findViewById<Button>(R.id.addHistoryItem).setOnClickListener {
                    val name =
                        view.findViewById<TextInputEditText>(R.id.historyNameTxtField).text.toString()
                    val date =
                        view.findViewById<TextInputEditText>(R.id.dateTxtField).text.toString()
                    val description =
                        view.findViewById<TextInputEditText>(R.id.descriptionTxtField).text.toString()

                    ArchiveContent.addItem(name, date, description)

                    val mainActivity: MainActivity = requireActivity() as MainActivity
                    mainActivity.refreshFragmentList()
                    dismiss()
                }
            }
        }
    }
}