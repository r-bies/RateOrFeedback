package jp.co.runners.rateorfeedback

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog

class AskLikeAppDialogFragment : DialogFragment() {
    lateinit var option: AskLikeAppDialogOption

    companion object {
        fun newInstance(option: AskLikeAppDialogOption): AskLikeAppDialogFragment {
            val instance = AskLikeAppDialogFragment()
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