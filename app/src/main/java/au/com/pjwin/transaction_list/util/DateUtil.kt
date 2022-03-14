package au.com.pjwin.transaction_list.util

import java.text.SimpleDateFormat
import java.time.DateTimeException
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

object DateUtil {

    private val transDateFormatter = SimpleDateFormat("E d MMM", Locale.getDefault())

    @Synchronized
    fun formatTransDate(date: Date): String =
        transDateFormatter.format(date)

}