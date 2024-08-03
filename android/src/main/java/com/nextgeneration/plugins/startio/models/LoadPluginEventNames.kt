package com.nextgeneration.plugins.startio.models

interface LoadPluginEventNames {
    val Hidden: String
    val FailedToReceiveAd: String
    val Displayed: String
    val Clicked: String
    val NotDisplayed: String
    val Loaded: String
    val ExceptionError: String
}