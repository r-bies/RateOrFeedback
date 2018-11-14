package jp.co.runners.rateorfeedback

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log

const val TAG = "RateOrFeedback"

class RateOrFeedback(activity: AppCompatActivity?, fragment: Fragment?) {
    val fragment = fragment
    val activity = activity
    val context: Context = activity ?: fragment?.requireContext()
    ?: throw IllegalArgumentException("Invalid Constructor")

    constructor(activity: AppCompatActivity) : this(activity, null)

    constructor(fragment: Fragment) : this(null, fragment)

    private fun showDialogFragment(dialogFragment: DialogFragment) {
        if (activity != null) {
            dialogFragment.show(activity.supportFragmentManager, dialogFragment.javaClass.simpleName)
        } else if (fragment != null) {
            dialogFragment.show(fragment.childFragmentManager, dialogFragment.javaClass.simpleName)
        }
    }

    private fun startActivity(intent: Intent) {
        if (activity != null) {
            activity.startActivity(intent)
        } else if (fragment != null) {
            fragment.startActivity(intent)
        }
    }

    val askLikeAppDialogOption = AskLikeAppDialogOption().apply {
        message = context.getString(R.string.RateOrFeedback_AskLikeAppMessage)
        positiveButtonTitle = context.getString(R.string.RateOrFeedback_AskLikeAppPositive)
        negativeButtonTitle = context.getString(R.string.RateOrFeedback_AskLikeAppNegative)
        onPositive = {
            val requestReviewDialog = RequestReviewDialogFragment.newInstance(requestReviewDialogOption)
            showDialogFragment(requestReviewDialog)
        }
        onNegative = {
            val requestFeedbackDialog = RequestFeedbackDialogFragment.newInstance(requestFeedbackDialogOption)
            showDialogFragment(requestFeedbackDialog)
        }
        onPositiveWrapper = {
            onPositive?.invoke()
        }
        onNegativeWrapper = {
            onNegative?.invoke()
        }
    }
    val requestReviewDialogOption = RequestReviewDialogOption().apply {
        message = context.getString(R.string.RateOrFeedback_RequestReviewMessage)
        positiveButtonTitle = context.getString(R.string.RateOrFeedback_RequestReviewPositive)
        negativeButtonTitle = context.getString(R.string.RateOrFeedback_RequestReviewNegative)
        onPositive = {
            playStoreUrl?.let {
                val uri = Uri.parse(it)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
        onNegative = {
            // dismiss
        }
        onPositiveWrapper = {
            onPositive?.invoke()
            saveLastOperatedReviewRequestId(context, reviewRequestId)
        }
        onNegativeWrapper = {
            onNegative?.invoke()
        }
    }
    val requestFeedbackDialogOption = RequestFeedbackDialogOption().apply {
        message = context.getString(R.string.RateOrFeedback_RequestFeedbackMessage)
        positiveButtonTitle = context.getString(R.string.RateOrFeedback_RequestFeedbackPositive)
        negativeButtonTitle = context.getString(R.string.RateOrFeedback_RequestFeedbackNegative)
        onPositive = {
            feedbackEmail?.let {
                val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", it, null))
                intent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.RateOrFeedback_FeedbackEmailTitle))
                startActivity(intent)
            }
        }
        onNegative = {
            // dismiss
        }
        onPositiveWrapper = {
            onPositive?.invoke()
            saveLastOperatedReviewRequestId(context, reviewRequestId)
        }
        onNegativeWrapper = {
            onNegative?.invoke()
        }
    }
    private var playStoreUrl: String? = null
    private var feedbackEmail: String? = null
    private var reviewRequestId = 0
    private var intervalFromPreviousShowing = 60 * 60 * 24 * 7L
    private var notShowTermSecondsFromInstall = 60 * 60 * 24 * 7L
    private var isDebug = false

    fun setAskLikeAppDialogMessage(value: String): RateOrFeedback {
        askLikeAppDialogOption.message = value
        return this
    }

    fun setAskLikeAppDialogPositiveTitle(value: String): RateOrFeedback {
        askLikeAppDialogOption.positiveButtonTitle = value
        return this
    }

    fun setAskLikeAppDialogNegativeTitle(value: String): RateOrFeedback {
        askLikeAppDialogOption.negativeButtonTitle = value
        return this
    }

    fun setAskLikeAppDialogOnPositive(value: () -> Unit): RateOrFeedback {
        askLikeAppDialogOption.onPositive = value
        return this
    }

    fun setAskLikeAppDialogOnNegative(value: () -> Unit): RateOrFeedback {
        askLikeAppDialogOption.onNegative = value
        return this
    }

    fun setRequestReviewDialogMessage(value: String): RateOrFeedback {
        requestReviewDialogOption.message = value
        return this
    }

    fun setRequestReviewDialogPositiveTitle(value: String): RateOrFeedback {
        requestReviewDialogOption.positiveButtonTitle = value
        return this
    }

    fun setRequestReviewDialogNegativeTitle(value: String): RateOrFeedback {
        requestReviewDialogOption.negativeButtonTitle = value
        return this
    }

    fun setRequestReviewDialogOnPositive(value: () -> Unit): RateOrFeedback {
        requestReviewDialogOption.onPositive = value
        return this
    }

    fun setRequestReviewDialogOnNegative(value: () -> Unit): RateOrFeedback {
        requestReviewDialogOption.onNegative = value
        return this
    }

    fun setRequestFeedbackDialogMessage(value: String): RateOrFeedback {
        requestFeedbackDialogOption.message = value
        return this
    }

    fun setRequestFeedbackDialogPositiveTitle(value: String): RateOrFeedback {
        requestFeedbackDialogOption.positiveButtonTitle = value
        return this
    }

    fun setRequestFeedbackDialogNegativeTitle(value: String): RateOrFeedback {
        requestFeedbackDialogOption.negativeButtonTitle = value
        return this
    }

    fun setRequestFeedbackDialogOnPositive(value: () -> Unit): RateOrFeedback {
        requestFeedbackDialogOption.onPositive = value
        return this
    }

    fun setRequestFeedbackDialogOnNegative(value: () -> Unit): RateOrFeedback {
        requestFeedbackDialogOption.onNegative = value
        return this
    }

    fun setPlayStoreUrl(value: String): RateOrFeedback {
        playStoreUrl = value
        return this
    }

    fun setFeedbackEmail(value: String): RateOrFeedback {
        feedbackEmail = value
        return this
    }

    fun setReviewRequestId(value: Int): RateOrFeedback {
        reviewRequestId = value
        return this
    }

    fun setIntervalFromPreviousShowing(value: Long): RateOrFeedback {
        intervalFromPreviousShowing = value
        return this
    }

    fun setIsDebug(value: Boolean): RateOrFeedback {
        isDebug = value
        return this
    }

    fun setNotShowTermSecondsFromInstall(value: Long): RateOrFeedback {
        notShowTermSecondsFromInstall = value
        return this
    }

    fun show() {
        val askLikeAppDialog = AskLikeAppDialogFragment.newInstance(askLikeAppDialogOption)
        showDialogFragment(askLikeAppDialog)
    }

    fun showIfNeeds() {
        val installTimestamp = context.packageManager.getPackageInfo(context.packageName, 0).firstInstallTime / 1000
        val nowTimestamp = System.currentTimeMillis() / 1000
        if (nowTimestamp < installTimestamp + notShowTermSecondsFromInstall) {
            log("[SKIP_SHOW] notShowTermSecondsFromInstall is not elapsed.")
            return
        }


        val lastShowDialogTimestamp = getLastShowDialogTimestamp(context)
        if (nowTimestamp < lastShowDialogTimestamp + intervalFromPreviousShowing) {
            log("[SKIP_SHOW] intervalFromPreviousShowing is not elapsed.")
            return
        }

        val lastOperatedReviewRequestId = getLastOperatedReviewRequestId(context)
        if (lastOperatedReviewRequestId == reviewRequestId) {
            log("[SKIP_SHOW] already operated in this reviewRequestId.")
            return
        }

        show()
        saveLastShowDialogTimestamp(context, nowTimestamp)
    }

    private fun log(o: Any) {
        Log.d(TAG, o.toString())
    }

}