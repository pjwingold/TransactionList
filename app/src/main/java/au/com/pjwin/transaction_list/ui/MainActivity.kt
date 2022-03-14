package au.com.pjwin.transaction_list.ui

import au.com.pjwin.commonlib.ui.NavGraphModel
import au.com.pjwin.commonlib.ui.ViewActivity
import au.com.pjwin.transaction_list.R

class MainActivity : ViewActivity() {

    override fun navGraph(): NavGraphModel {
        return NavGraphModel(R.navigation.navigation_trans)
    }
}