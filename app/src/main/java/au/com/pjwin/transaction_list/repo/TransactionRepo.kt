package au.com.pjwin.transaction_list.repo

import au.com.pjwin.commonlib.repo.retrofit.NetworkResult
import au.com.pjwin.commonlib.repo.retrofit.RetrofitRepo
import au.com.pjwin.commonlib.repo.retrofit.safeApiCall
import au.com.pjwin.transaction_list.model.AccountTransactions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object TransactionRepo {

    private val transactionService: TransactionService by lazy {
        RetrofitRepo.RETROFIT_BASIC_AUTH.create(TransactionService::class.java)
    }

    suspend fun getAccountTransactions(): Flow<NetworkResult<AccountTransactions>> {
        return flow {
            emit(safeApiCall {
                transactionService.getAccountTransactions()
            })
        }
    }
}