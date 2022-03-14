package au.com.pjwin.transaction_list.util

import au.com.pjwin.transaction_list.model.Transaction
import java.math.BigDecimal
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate.now
import java.util.Calendar
import java.util.Currency
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit
import kotlin.math.abs

private val transDateFormatter: SimpleDateFormat by lazy {
    SimpleDateFormat("E d MMM", Locale.getDefault())
}

@Synchronized
fun formatTransDate(date: Date): String =
    transDateFormatter.format(date)

@JvmOverloads
fun BigDecimal?.currencyFormat(currencyCode: String = "USD"): String {
    val format = NumberFormat.getCurrencyInstance()
    format.currency = Currency.getInstance(currencyCode)
    return format.format(this ?: 0)
}

fun Transaction.formatDisplay(): String {
    return (if (isPending) "<b>PENDING:</b> " else " ") + description
}

fun Date.getDaysFromToday(): Long {
    val diff = abs(Calendar.getInstance().time.time  - this.time)
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
}