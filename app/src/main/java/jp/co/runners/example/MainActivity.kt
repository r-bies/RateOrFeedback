package jp.co.runners.example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import jp.co.runners.rateorfeedback.RateOrFeedback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonRateOrFeedback.setOnClickListener {
            RateOrFeedback(this)
                    .setPlayStoreUrl("https://play.google.com/store/apps/details?id=com.google.android.gm")
                    .setFeedbackEmail("email@example.com")
                    .show() // or .showIfNeeds()
        }
    }
}
