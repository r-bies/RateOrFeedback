package jp.co.runners.rateorfeedback

import android.content.Context
import android.preference.PreferenceManager

const val KEY_LAST_OPERATED_REVIEW_REQUEST_ID = "RateOrFeedback.last_operated_review_request_id"
const val KEY_LAST_SHOW_DIALOG_TIMESTAMP = "RateOrFeedback.last_show_dialog_timestamp"
fun getSharedPreferences(context: Context) = PreferenceManager.getDefaultSharedPreferences(context)

fun saveLastOperatedReviewRequestId(context: Context, value: Int) {
    val sharedPreferences = getSharedPreferences(context)
    sharedPreferences.edit().putInt(KEY_LAST_OPERATED_REVIEW_REQUEST_ID, value).commit()
}

fun getLastOperatedReviewRequestId(context: Context): Int {
    val sharedPreferences = getSharedPreferences(context)
    return sharedPreferences.getInt(KEY_LAST_OPERATED_REVIEW_REQUEST_ID, -1)
}

fun saveLastShowDialogTimestamp(context: Context, value: Long) {
    val sharedPreferences = getSharedPreferences(context)
    sharedPreferences.edit().putLong(KEY_LAST_SHOW_DIALOG_TIMESTAMP, value).commit()
}

fun getLastShowDialogTimestamp(context: Context): Long {
    val sharedPreferences = getSharedPreferences(context)
    return sharedPreferences.getLong(KEY_LAST_SHOW_DIALOG_TIMESTAMP, 0L)
}
