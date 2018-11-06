package jp.co.runners.rateorfeedback

class AskLikeAppDialogOption {
    var message = ""
    var positiveButtonTitle = ""
    var negativeButtonTitle = ""
    var onPositive: (() -> Unit)? = null
    var onNegative: (() -> Unit)? = null
    var onPositiveWrapper: (() -> Unit)? = null
    var onNegativeWrapper: (() -> Unit)? = null
}