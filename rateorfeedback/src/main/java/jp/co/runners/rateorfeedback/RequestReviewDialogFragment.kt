package jp.co.runners.rateorfeedback

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment

class RequestReviewDialogFragment : DialogFragment() {
    lateinit var option: RequestReviewDialogOption

    companion object {
        fun newInstance(option: RequestReviewDialogOption): RequestReviewDialogFragment {
            val instance = RequestReviewDialogFragment()
            instance.option = option
            return instance
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return AlertDialog.Builder(requireContext())
                .setCancelable(false)
                .setMessage(option.message)
                .setPositiveButton(option.positiveButtonTitle) { dialogInterface, i ->
                    option.onPositiveWrapper?.invoke()
                }
                .setNegativeButton(option.negativeButtonTitle) { dialogInterface, i ->
                    option.onNegativeWrapper?.invoke()

                }
                .create()
    }
}