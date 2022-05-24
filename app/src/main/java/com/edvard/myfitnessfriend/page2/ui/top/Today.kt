package com.edvard.myfitnessfriend.page2.ui.top

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.edvard.myfitnessfriend.AppStat
import com.edvard.myfitnessfriend.R
import kotlinx.android.synthetic.main.exerciseresult.*
import kotlinx.android.synthetic.main.fragment_today.*
import kotlinx.android.synthetic.main.fragment_today.exerciseTime
import kotlinx.android.synthetic.main.fragment_today.random
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Random

class Today : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_today, container, false)
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var now = LocalDate.now()
        var strNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        var month:String = strNow[5].toString() + strNow[6].toString()
        var day:String = strNow[8].toString() + strNow[9].toString()
        var today:String = month + "월" + day + "일"
        date.text = today
        todayCalorie.text = "76"

        val hour = AppStat.myStat.getTodayTime().toInt()/3600
        val min = AppStat.myStat.getTodayTime().toInt()/60 - hour * 60
        val sec = AppStat.myStat.getTodayTime().toInt()%60
        exerciseTime.text ="${hour}시간 30분 27초"
    }

    companion object{
        private const val num = "1"

        fun newInstance(Number: Int) : Today {
            return Today().apply{
                arguments = Bundle().apply {
                    arguments = Bundle().apply {
                        putInt(num, Number)
                    }
                }
            }
        }
    }
    fun main(args : Array<String>) {

        /*
        [설 명]
        1. import java.util.Random : 코틀린에서 Random 객체를 사용하기 위한 필수 import 선언입니다
        2. nextInt(6)+1 : 1부터 6까지 랜덤한 정수 값 범위를 지정합니다
        */

        println("[Random 객체를 사용해서 랜덤 정수값 출력 실시]")

        //int 변수 선언 및 Random 데이터 삽입 실시
        var int_random = Random().nextInt(30) + 15
        random.text= "${int_random} 점"
    }
}
