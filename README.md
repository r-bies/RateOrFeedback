# About RateOrFeedback
This is a android library that help developers add rating/feedback screen.

![screenshot](doc/screenshot.png?raw=true "screenshot")

# How to use
Add this to your project build.gradle if it needs.
```
repositories {
    jcenter()
}
```

Add this to your app build.gradle.
```
dependencies {
    implementation 'TODO'
}
```

Call RateOrFeedback like this.

```
RateOrFeedback(this)
        // Use your playstore url
        .setPlayStoreUrl("https://play.google.com/store/apps/details?id=com.google.android.gm")
        // Use your feedback email
        .setFeedbackEmail("email@example.com")
        // Show the dialog always
        .show()
```

# Options
Full options is here.

```
RateOrFeedback(this)
        // Your app store url
        .setPlayStoreUrl("")
        // Your feedback email address.
        .setFeedbackEmail("email@example.com")
        // [Use with showIfNeeds]
        // Once a user select review or feedback, the dialog never show .
        // But increment this reviewRequestId, show the dialog again.
        .setReviewRequestId(0)
        // [Use with showIfNeeds]
        // Interval from previous showing the dialog.
        .setIntervalFromPreviousShowing(60 * 60 * 24 * 7)
        // [Use with showIfNeeds]
        // Not show the dialog term from the app installation.
        .setNotShowTermSecondsFromInstall(60 * 60 * 24 * 7)
        .setAskLikeAppDialogMessage("Are you enjoying this app?")
        .setAskLikeAppDialogPositiveTitle("Yes!")
        .setAskLikeAppDialogNegativeTitle("Not really")
        .setAskLikeAppDialogOnPositive {
            // If you want to do something instead of opening RequestReviewDialog,
            // set this callback
        }
        .setAskLikeAppDialogOnNegative {
            // If you want to do something instead of opening RequestFeedbackDialog,
            // set this callback
        }
        .setRequestReviewDialogMessage("Awesome! We'd love a play store review...")
        .setRequestReviewDialogPositiveTitle("Sure!")
        .setRequestReviewDialogNegativeTitle("Not right now")
        .setRequestReviewDialogOnPositive {
            // If you want to do something(like open your own activity) instead of opening the play store,
            // set this callback
        }
        .setRequestReviewDialogOnNegative {
            // If you want to do something,
            // set this callback
        }
        .setRequestFeedbackDialogMessage("Would you like to send feedback?")
        .setRequestFeedbackDialogPositiveTitle("Yes please!")
        .setRequestFeedbackDialogNegativeTitle("Not right now")
        .setRequestFeedbackDialogOnPositive {
            // If you want to do something(like open your own activity) instead of opening a mail app,
            // set this callback
        }
        .setRequestFeedbackDialogOnNegative {
            // If you want to do something,
            // set this callback
        }
        .showIfNeeds()
```

# License
Apache-2.0
