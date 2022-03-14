package au.com.pjwin.transaction_list.model

import androidx.annotation.DrawableRes
import au.com.pjwin.transaction_list.R
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable
import java.math.BigDecimal
import java.util.Date

@JsonClass(generateAdapter = true)
data class AccountTransactions(
    val account: Account,
    val transactions: List<Transaction>,
    val atms: List<Atm>
) : Serializable

@JsonClass(generateAdapter = true)
data class Account(
    val bsb: String,
    val accountNumber: String,
    val balance: BigDecimal,
    val available: BigDecimal,
    val accountName: String
) : Serializable

@JsonClass(generateAdapter = true)
data class Transaction(
    val amount: BigDecimal = BigDecimal(0),
    val id: String = "",
    val isPending: Boolean = false,
    val description: String = "",
    val category: TransactionCategory = TransactionCategory.UNCATEGORISED,
    val effectiveDate: Date
) : Serializable

@JsonClass(generateAdapter = true)
data class Atm(
    val id: String,
    val name: String,
    val location: LatLon,
    val address: String
) : Serializable

@JsonClass(generateAdapter = true)
data class LatLon(
    val lat: String,
    val lon: String
) : Serializable

enum class TransactionCategory(@DrawableRes val icon: Int) {
    @Json(name = "business")
    BUSINESS(R.drawable.icon_category_business),
    @Json(name = "cards")
    CARDS(R.drawable.icon_category_cards),
    @Json(name = "cash")
    CASH(R.drawable.icon_category_cash),
    @Json(name = "categories")
    CATEGORIES(R.drawable.icon_category_categories),
    @Json(name = "eatingOut")
    EATING_OUT(R.drawable.icon_category_eating_out),
    @Json(name = "education")
    EDUCATION(R.drawable.icon_category_education),
    @Json(name = "entertainment")
    ENTERTAINMENT(R.drawable.icon_category_entertainment),
    @Json(name = "groceries")
    GROCERIES(R.drawable.icon_category_groceries),
    @Json(name = "shopping")
    SHOPPING(R.drawable.icon_category_shopping),
    @Json(name = "transport")
    TRANSPORTATION(R.drawable.icon_category_transportation),
    @Json(name = "travel")
    TRAVEL(R.drawable.icon_category_travel),
    @Json(name = "uncategorised")
    UNCATEGORISED(R.drawable.icon_category_uncategorised);
}