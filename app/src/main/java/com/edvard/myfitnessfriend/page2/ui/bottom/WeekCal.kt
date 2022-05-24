package com.edvard.myfitnessfriend.page2.ui.bottom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edvard.myfitnessfriend.AppStat
import com.edvard.myfitnessfriend.Chart

import com.edvard.myfitnessfriend.R


class WeekCal : Fragment() {
   
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data1 = AppStat.myStat.getWeekCalorie()


    }
    companion object{
        private const val num = "2"

        fun newInstance(Number: Int) : WeekCal {
            return WeekCal().apply{
                arguments = Bundle().apply {
                    arguments = Bundle().apply {
                        putInt(num, Number)
                    }
                }
            }
        }
    }

}
