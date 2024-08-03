package com.nextgeneration.plugins.startio.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.getcapacitor.PluginCall;
import com.nextgeneration.plugins.startio.Bridge;
import com.nextgeneration.plugins.startio.models.Executor;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDK;
import com.startapp.sdk.adsbase.adlisteners.AdDisplayListener;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;


import androidx.core.util.Supplier;
import com.getcapacitor.JSObject;
import com.google.android.gms.common.util.BiConsumer;

public class AdInterstitialExecutor extends Executor {
    private Context context = null;
    private Activity activity = null;
    public StartAppAd interstitialAd = null;
    private static final String LOG_TAG = AdInterstitialExecutor.class.getSimpleName();

    /**public AdInterstitialExecutor(Context _ctx, Activity activity) {
        this.context = _ctx;
        this.interstitialAd = new StartAppAd(_ctx);
        this.activity = activity;
    }**/

    public AdInterstitialExecutor(
            Context _ctx,
            Activity activity,
            Supplier<Context> contextSupplier,
            Supplier<Activity> activitySupplier,
            BiConsumer<String, JSObject> notifyListenersFunction,
            String pluginLogTag
    ) {
        super(contextSupplier, activitySupplier, notifyListenersFunction, pluginLogTag, "AdRewardExecutor");
        this.context = _ctx;
        this.interstitialAd = new StartAppAd(_ctx);
        this.activity = activity;
    }

    // Setea el consentimiento del usuario para mostrar anuncios personalizados
    public void consent(Boolean _consent) {
        StartAppSDK.setUserConsent (context, "pas", System.currentTimeMillis(), _consent);
    }

    public void load(final PluginCall call){
        try{
            Intent intent = new Intent(context, Bridge.class);
            context.startActivity(intent);

            interstitialAd.loadAd(new AdEventListener() {
                @Override
                public void onReceiveAd(@NonNull Ad ad) {
                    var result = "loadInterstitial: onReceiveAd";
                    Log.v(LOG_TAG, result);

                    JSObject responseObject = new JSObject();
                    responseObject.put("result", result);

                    // Enviamos el evento de error
                    notifyListenersFunction.accept(InterstitialAdPluginEvent.INSTANCE.getLoaded(), responseObject);
                    call.resolve(responseObject);
                }

                @Override
                public void onFailedToReceiveAd(@Nullable Ad ad) {
                    var result = "loadInterstitial: onFailedToReceiveAd: " + (ad != null ? ad.getErrorMessage() : null);
                    Log.v(LOG_TAG, result);

                    JSObject errorObject = new JSObject();
                    errorObject.put("error", result);

                    // Enviamos el evento de error
                    notifyListenersFunction.accept(InterstitialAdPluginEvent.INSTANCE.getFailedToReceiveAd(), errorObject);
                    call.reject(result);
                }
            });
        }catch (Exception e){
            var r = "Interstitial is not ready " + e.getMessage();
            Toast.makeText(context, r, Toast.LENGTH_SHORT).show();

            JSObject errorObject = new JSObject();
            errorObject.put("error", r);
            notifyListenersFunction.accept(InterstitialAdPluginEvent.INSTANCE.getExceptionError(), errorObject);
            call.reject(r);
        }
    }

    public void show(final PluginCall call){
        try{
            interstitialAd.showAd(new AdDisplayListener() {
                @Override
                public void adHidden(Ad ad) {
                    var result = "showInterstitial: adHidden";
                    Log.v(LOG_TAG, result);

                    JSObject responseObject = new JSObject();
                    responseObject.put("result", result);

                    // Enviamos el evento de error
                    notifyListenersFunction.accept(InterstitialAdPluginEvent.INSTANCE.getHidden(), responseObject);
                }

                @Override
                public void adDisplayed(Ad ad) {
                    var result = "showInterstitial: adDisplayed";
                    Log.v(LOG_TAG, result);

                    JSObject responseObject = new JSObject();
                    responseObject.put("result", result);

                    // Enviamos el evento de error
                    notifyListenersFunction.accept(InterstitialAdPluginEvent.INSTANCE.getDisplayed(), responseObject);
                }

                @Override
                public void adClicked(Ad ad) {
                    var result = "showInterstitial: adClicked";
                    Log.v(LOG_TAG, result);

                    JSObject responseObject = new JSObject();
                    responseObject.put("result", result);

                    // Enviamos el evento de error
                    notifyListenersFunction.accept(InterstitialAdPluginEvent.INSTANCE.getClicked(), responseObject);
                }

                @Override
                public void adNotDisplayed(Ad ad) {
                    var result = "showInterstitial: adNotDisplayed";
                    Log.v(LOG_TAG, result);

                    JSObject responseObject = new JSObject();
                    responseObject.put("result", result);

                    // Enviamos el evento de error
                    notifyListenersFunction.accept(InterstitialAdPluginEvent.INSTANCE.getNotDisplayed(), responseObject);
                }
            });
        }catch (Exception e){
            var r = "Interstitial is not ready " + e.getMessage();
            Toast.makeText(context, r, Toast.LENGTH_SHORT).show();

            JSObject errorObject = new JSObject();
            errorObject.put("error", r);
            notifyListenersFunction.accept(InterstitialAdPluginEvent.INSTANCE.getExceptionError(), errorObject);

            call.reject(r);
        }
    }
}
