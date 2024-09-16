package com.kawunus.mythings

object WordEndingHelper {
    fun getWordForm(count: Int, form1: String, form2: String, form5: String): String {
        val mod100 = count % 100
        val mod10 = count % 10

        return when {
            mod100 in 11..19 -> form5
            mod10 == 1 -> form1
            mod10 in 2..4 -> form2
            else -> form5
        }
    }
}
