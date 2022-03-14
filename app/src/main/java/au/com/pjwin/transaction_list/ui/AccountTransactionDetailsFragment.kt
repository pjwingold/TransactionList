package au.com.pjwin.transaction_list.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import au.com.pjwin.commonlib.ui.BaseFragment
import au.com.pjwin.commonlib.viewmodel.VoidViewModel
import au.com.pjwin.transaction_list.R
import au.com.pjwin.transaction_list.databinding.FragmentTransactionDetailsBinding

class AccountTransactionDetailsFragment : BaseFragment<Void, VoidViewModel, FragmentTransactionDetailsBinding>() {

    private val args: AccountTransactionDetailsFragmentArgs by navArgs()

    override fun layoutId() = R.layout.fragment_transaction_details

    override fun pageTitle() = R.string.title_transaction_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.transaction = args.transaction
    }
}