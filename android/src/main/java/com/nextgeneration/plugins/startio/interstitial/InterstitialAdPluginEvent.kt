package com.nextgeneration.plugins.startio.interstitial

import com.nextgeneration.plugins.startio.models.LoadPluginEventNames

object InterstitialAdPluginEvent: LoadPluginEventNames {

    override val Hidden = "interstitialAdHidden"
    override val FailedToReceiveAd = "interstitialFailedToReceiveAd"
    override val Displayed = "interstitialDisplayed"
    override val Clicked = "interstitialClicked"
    override val NotDisplayed = "interstitialNotDisplayed"
    override val Loaded = "interstitialLoaded"
    override val ExceptionError = "interstititalExceptionError"
}