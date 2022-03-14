package au.com.pjwin.transaction_list.util

import au.com.pjwin.commonlib.Common
import au.com.pjwin.transaction_list.BuildConfig


class AppConfig : Common.Config {

    override fun host() = BuildConfig.HOST

    override fun port(): Int = BuildConfig.PORT

    override fun schema(): String = BuildConfig.SCHEMA

    override fun readTimeout() = BuildConfig.READ_TIMEOUT

    override fun connectionTimeout() = BuildConfig.CONNECTION_TIMEOUT

    override fun debug() = BuildConfig.DEBUG
}