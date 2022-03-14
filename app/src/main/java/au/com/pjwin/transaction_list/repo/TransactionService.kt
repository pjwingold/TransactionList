package au.com.pjwin.transaction_list.repo

import au.com.pjwin.transaction_list.model.AccountTransactions
import retrofit2.Response
import retrofit2.http.GET

interface TransactionService {

    @GET("s/inyr8o29shntk9w/exercise.json?dl=1")
    suspend fun getAccountTransactions(): Response<AccountTransactions>
}